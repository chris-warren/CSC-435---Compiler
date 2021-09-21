package ir;
import java.util.ArrayList;
import java.io.*;
import TYPES.*;

public class JGenerator{
    public String output;
    public String fileName;
    public ArrayList<IRFunction> fList;
    public int curLabel;
    public TempFactory factory;

    public JGenerator(ArrayList<IRFunction> fs, String n){
        fileName = n;
        fList = fs;
        output = "";
        curLabel = 0;
    }
    public void writeToFile(){
        output  = output + ".source ";
        output  = output + fileName + ".ir\n";
        output  = output + ".class public " + fileName+"\n";
        output  = output + ".super java/lang/Object\n\n";

        for(int i = 0; i < fList.size(); i++){
            fList.get(i).accept(this);
            output = output +".end method";
            output  = output + "\n\n";
        }
        output  = output + ";--------------------------------------------;\n";
        output  = output + ";                                            ;\n";
        output  = output + "; Boilerplate                                ;\n";
        output  = output + ";                                            ;\n";
        output  = output + ";--------------------------------------------;\n";
        output  = output + ".method public static main([Ljava/lang/String;)V\n";
        output  = output + "	; set limits used by this method\n";
        output  = output + "	.limit locals 1\n";
        output  = output + "	.limit stack 16\n";
        output  = output + "	invokestatic "+fileName+"/__main()V\n";
        output  = output + "	return\n";
        output  = output + ".end method\n\n";
        output  = output + "; standard initializer\n";
        output  = output + ".method public <init>()V\n";
        output  = output + "	aload_0\n";
        output  = output + "	invokenonvirtual java/lang/Object/<init>()V\n";
        output  = output + "	return\n";
        output  = output + ".end method\n";
        try{
            FileWriter fileWriter = new FileWriter("IR_test_files/"+fileName+".j", false);
            fileWriter.write(output);
            fileWriter.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }  

    public void visit(Instruction i){
        return;

    }
    public void visit(IRAddOp o){
        Type type = o.type;
        String n1 = o.temp1.name;
        String n2 = o.temp2.name;

        if(type instanceof IntegerType){
            output = output + "\tiload "+n1+"\n";
            output = output + "\tiload "+n2+"\n";
            output = output + "\tiadd\n";
        }
        else if(type instanceof FloatType){
            output = output + "\tfload "+n1+"\n";
            output = output + "\tfload "+n2+"\n";
            output = output + "\tfadd\n";
        }
        else if(type instanceof CharType){
            output = output + "\tiload "+n1+"\n";
            output = output + "\tiload "+n2+"\n";
            output = output + "\tiadd\n";
            output = output + "\ti2c\n";
        }
        // TO DO add string addition
        return;
    }
    public void visit(IRArrayInitialization a, Temp temp){

        //declare
        Type type = a.type;
        output = output + "\tldc "+((ArrayType)type).size+"\n";
        if(((ArrayType)type).t instanceof IntegerType){
            output = output + "\tnewarray int\n";
        }
        else if(((ArrayType)type).t instanceof FloatType){
            output = output + "\tnewarray float\n";
        }
        else if(((ArrayType)type).t instanceof CharType){
            output = output + "\tnewarray char\n";
        }
        else if(((ArrayType)type).t instanceof StringType){
            output = output + "\tanewarray java/lang/String\n";
        }
        else if(((ArrayType)type).t instanceof BooleanType){
            output = output + "\tnewarray boolean\n";
        }
        output = output + "\tastore "+temp.name+"\n";


        return;
    }
    public void visit(IRArrayReference a){
        Type type = a.type;
        String n1 = a.id.name;
        String n2 = a.index.name;
        output = output + "\taload "+n1+"\n";
        output = output + "\tiload "+n2+"\n";
        if(type instanceof IntegerType){
             output = output + "\tiaload \n";
        }
        else if(type instanceof FloatType){
             output = output + "\tfaload \n";
        }
        else if(type instanceof CharType){
             output = output + "\tcaload \n";
        }
        else if(type instanceof StringType){
             output = output + "\taaload \n";
        }
        else if(type instanceof BooleanType){
             output = output + "\tbaload \n";
        }
        
        return;
    }
    public void visit(IRAssignment a){
        Temp t = a.temp;
        IROperand o = a.op;
        Type type = t.type;

        if(o instanceof IRArrayInitialization){
            visit((IRArrayInitialization)o, t);
        }else if( t instanceof IRArrayReference){
            arrayAssignmentHelper(t, o);
        }else{
            o.accept(this);
            if(type instanceof StringType){
                output = output + "\tastore ";
            }
            else if(type instanceof IntegerType){
                output = output + "\tistore ";
            }
            else if(type instanceof FloatType){
                output = output + "\tfstore ";
            }
            else if(type instanceof CharType){
                output = output + "\tistore ";
            }
            else if(type instanceof BooleanType){
                output = output + "\tistore ";
            }
            else if(type instanceof ArrayType){
                output = output + "\tastore ";
                output = output + t.name.substring(1);
                return;
            }

            output = output + t.name;
        }

        return;
    }
    public void arrayAssignmentHelper(Temp temp, IROperand op){
        output = output +"\taload "+((IRArrayReference)temp).id.name+"\n";
        
        Type type = ((ArrayType)temp.type).t;
        if(type instanceof StringType){
            output = output +"\tiload "+((IRArrayReference)temp).index.name+"\n";
            op.accept(this);
            output = output +"\taastore\n";
        }
        else if(type instanceof IntegerType){
            output = output +"\tiload "+((IRArrayReference)temp).index.name+"\n";
            op.accept(this);
            output = output +"\tiastore\n";
        }
        else if(type instanceof FloatType){
            output = output +"\tiload "+((IRArrayReference)temp).index.name+"\n";
            op.accept(this);
            output = output +"\tfastore\n";
        }
        else if(type instanceof CharType){
            output = output +"\tiload "+((IRArrayReference)temp).index.name+"\n";
            op.accept(this);
            output = output +"\tcastore\n";
        }
        else if(type instanceof BooleanType){
            output = output +"\tiload "+((IRArrayReference)temp).index.name+"\n";
            op.accept(this);
            output = output +"\tbastore\n";
        }
    }
    public void visit(IRBinaryOp o){
        return;
    }
    public void visit(IRBoolNeg b){
        output = output +"\tiload "+b.op.name+"\n";
        output = output +"\tldc 1\n";
        output = output +"\tixor\n";


        return;
    }
    public void visit(IRConditionalGoTo g){
        output = output + "\tiload "+g.cond.name+"\n";
        output = output + "\tifne L"+g.label.name+"\n";

        return;
    }
    public void visit(IRConst c){
        if(c.type instanceof StringType){
            output = output + "\tldc "+'"'+c.val+'"'+"\n";
        }
        else if(c.type instanceof CharType){
            char a = (char)c.val;
            int b = a;
            output = output + "\tldc "+Integer.toString(a)+"\n";
        }
        else if(c.type instanceof BooleanType){
            output = output + "\tldc ";
            if((boolean)c.val){
                output = output + "1";
            }else{
                output = output + "0";
            }
            
            output = output +"\n";
        }
        else if(c.type instanceof FloatType){
            output = output + "\tldc "+String.format("%.6f", c.val)+"\n";
        }
        else{
            output = output + "\tldc "+c.val+"\n";
        }
        return;
    }
    public void visit(IREqualityOp o){
        Type type = o.type;
        String n1 = o.temp1.name;
        String n2 = o.temp2.name;
        if(type instanceof StringType){
            output = output + "\taload "+n1+"\n";
            output = output + "\taload "+n2+"\n";
            output = output + "\tinvokevirtual java/lang/String/compareTo(Ljava/lang/String;)I\n";
            output = output + "\tifeq L_"+Integer.toString(curLabel)+"\n";
            curLabel++;
            output = output + "\tldc 0\n";
            output = output + "\tgoto L_"+Integer.toString(curLabel)+"\n";
            curLabel++;
            output = output + "L_"+Integer.toString(curLabel-2)+":\n";
            output = output + "\tldc 1\n";
            output = output + "L_"+Integer.toString(curLabel-1)+":\n";
        }
        else if(type instanceof IntegerType){
            output = output + "\tiload "+n1+"\n";
            output = output + "\tiload "+n2+"\n";
            output = output + "\tisub\n";
            output = output + "\tifeq L_"+Integer.toString(curLabel)+"\n";
            curLabel++;
            output = output + "\tldc 0\n";
            output = output + "\tgoto L_"+Integer.toString(curLabel)+"\n";
            curLabel++;
            output = output + "L_"+Integer.toString(curLabel-2)+":\n";
            output = output + "\tldc 1\n";
            output = output + "L_"+Integer.toString(curLabel-1)+":\n";
        }
        else if(type instanceof FloatType){
            output = output + "\tfload "+n1+"\n";
            output = output + "\tfload "+n2+"\n";
            output = output + "\tfcmpg\n";
            output = output + "\tifeq L_"+Integer.toString(curLabel)+"\n";
            curLabel++;
            output = output + "\tldc 0\n";
            output = output + "\tgoto L_"+Integer.toString(curLabel)+"\n";
            curLabel++;
            output = output + "L_"+Integer.toString(curLabel-2)+":\n";
            output = output + "\tldc 1\n";
            output = output + "L_"+Integer.toString(curLabel-1)+":\n";
        }
        else if(type instanceof CharType){
            output = output + "\tiload "+n1+"\n";
            output = output + "\tiload "+n2+"\n";
            output = output + "\tisub\n";
            output = output + "\tifeq L_"+Integer.toString(curLabel)+"\n";
            curLabel++;
            output = output + "\tldc 0\n";
            output = output + "\tgoto L_"+Integer.toString(curLabel)+"\n";
            curLabel++;
            output = output + "L_"+Integer.toString(curLabel-2)+":\n";
            output = output + "\tldc 1\n";
            output = output + "L_"+Integer.toString(curLabel-1)+":\n";
        }
        else if(type instanceof BooleanType){
            output = output + "\tiload "+n1+"\n";
            output = output + "\tiload "+n2+"\n";
            output = output + "\tixor\n";
            output = output + "\tldc 1\n";
            output = output + "\tixor\n";
        }




        return;
    }
    public void visit(IRFuncCallInstruction f){
        for(int i = 0; i < f.arguments.size(); i++){
            Temp t = f.arguments.get(i);
            if(t.type instanceof StringType){
                output = output + "\taload ";
            }
            else if(t.type instanceof IntegerType){
                output = output + "\tiload ";
            }
            else if(t.type instanceof FloatType){
                output = output + "\tfload ";
            }
            else if(t.type instanceof CharType){
                output = output + "\tiload ";
            }
            else if(t.type instanceof BooleanType){
                output = output + "\tiload ";
            }
            else if(t.type instanceof ArrayType){
                output = output + "\taload ";
            }
            output = output + t.name+"\n";
        }
        output = output + "\tinvokestatic " +fileName+"/"+f.fName+"(";
        

        for(int i = 0; i < f.arguments.size(); i++){
            if(f.arguments.get(i).type instanceof ArrayType){
                output = output + "[";
            }
            if(f.arguments.get(i).type instanceof StringType){
                output = output + "Ljava/lang/String;";
            }else{
                output = output + f.arguments.get(i).type.toShortString();
            }
            
        }
        if(f.rType instanceof StringType){
            output = output + ")"+ "Ljava/lang/String;" +"\n";
        }else{
            output = output + ")"+f.rType.toShortString()+"\n";
        }
        return;
    }
    public void visit(IRFuncCallOp f){
        for(int i = 0; i < f.arguments.size(); i++){
            Temp t = f.arguments.get(i);
            if(t.type instanceof StringType){
                output = output + "\taload ";
            }
            else if(t.type instanceof IntegerType){
                output = output + "\tiload ";
            }
            else if(t.type instanceof FloatType){
                output = output + "\tfload ";
            }
            else if(t.type instanceof CharType){
                output = output + "\tiload ";
            }
            else if(t.type instanceof BooleanType){
                output = output + "\tiload ";
            }
            else if(t.type instanceof ArrayType){
                output = output + "\taload ";
            }
            output = output + t.name+"\n";
        }
        output = output + "\tinvokestatic " +fileName+"/"+f.fName+"(";
        

        for(int i = 0; i < f.arguments.size(); i++){
            if(f.arguments.get(i).type instanceof ArrayType){
                output = output + "[";
            }
            if(f.arguments.get(i).type instanceof StringType){
                output = output + "Ljava/lang/String;";
            }else{
                output = output + f.arguments.get(i).type.toShortString();
            }
            
        }
        if(f.rType instanceof StringType){
            output = output + ")"+ "Ljava/lang/String;" +"\n";
        }else{
            output = output + ")"+f.rType.toShortString()+"\n";
        }
        return;
    }
    public void visit(IRFunction f){
        factory = f.tempFactory;
        output = output + ".method public static ";
        if(f.name.equals("main")){
            output = output + "__";
        }
        output = output + f.name + "(";
        for(int i = 0; i < f.pList.size(); i++){
            if(f.pList.get(i) instanceof ArrayType){
                output = output + "[";
            }
            if(f.pList.get(i) instanceof StringType){
                output = output + "Ljava/lang/String;";
            }else{
                output = output + f.pList.get(i).toShortString();
            }
            
        }
        if(f.returnType instanceof StringType){
            output = output + ")"+ "Ljava/lang/String;" +"\n";
        }else{
            output = output + ")"+f.returnType.toShortString()+"\n";
        }
        
        //might have to go back and set right amount of locals
        output = output + "	.limit locals "+Integer.toString(factory.tList.size())+"\n";

        for(int i = 0; i < factory.tList.size(); i++){
            output = output + "\t.var "+Integer.toString(i)+" is T"+factory.tList.get(i).name+" ";
            if(factory.tList.get(i).type instanceof ArrayType){
                output = output + "[";
                if(((ArrayType)factory.tList.get(i).type).t instanceof StringType){
                    output = output + "Ljava/lang/String;";
                    output = output + " from L_" + Integer.toString(curLabel)+" to L_"+ Integer.toString(curLabel+1) + "\n";
                    continue;
                }
            }

            if(factory.tList.get(i).type instanceof StringType){
                output = output + "Ljava/lang/String;";
            }else{
                    output = output + factory.tList.get(i).type.toShortString();  
            }
            output = output + " from L_" + Integer.toString(curLabel)+" to L_"+ Integer.toString(curLabel+1) + "\n";
        }
        output = output + "	.limit stack 16\n";
        output = output + "L_"+Integer.toString(curLabel)+":\n";
        curLabel++;
        int nextLabel =curLabel;
        curLabel++;
        for(int i = 0; i < f.iList.size(); i++){
            f.iList.get(i).accept(this);
            output = output +"\n";
        }
        output = output + "L_"+Integer.toString(nextLabel)+":\n";
        return;
    }
    public void visit(IRLessThanOp o){
        Type type = o.type;
        String n1 = o.temp1.name;
        String n2 = o.temp2.name;
        if(type instanceof IntegerType){
            output = output + "\tiload "+o.temp1.name+"\n";
            output = output + "\tiload "+o.temp2.name+"\n";
            output = output + "\tisub\n";
            output = output + "\tiflt L_"+Integer.toString(curLabel)+"\n";
            curLabel ++;
            output = output + "\tldc 0\n";
            output = output + "\tgoto L_"+Integer.toString(curLabel)+"\n";
            curLabel ++;
            output = output + "\tL_"+Integer.toString(curLabel-2)+":\n";
            output = output + "\tldc 1\n";
            output = output + "\tL_"+Integer.toString(curLabel-1)+":\n";
        }
        else if(type instanceof FloatType){
            output = output + "\tfload "+o.temp1.name+"\n";
            output = output + "\tfload "+o.temp2.name+"\n";
            output = output + "\tfcmpg\n";
            output = output + "\tiflt L_"+Integer.toString(curLabel)+"\n";
            curLabel ++;
            output = output + "\tldc 0\n";
            output = output + "\tgoto L_"+Integer.toString(curLabel)+"\n";
            curLabel ++;
            output = output + "\tL_"+Integer.toString(curLabel-2)+":\n";
            output = output + "\tldc 1\n";
            output = output + "\tL_"+Integer.toString(curLabel-1)+":\n";
        }
        else if(type instanceof CharType){
            output = output + "\tiload "+o.temp1.name+"\n";
            output = output + "\tiload "+o.temp2.name+"\n";
            output = output + "\tisub\n";
            output = output + "\tiflt L_"+Integer.toString(curLabel)+"\n";
            curLabel ++;
            output = output + "\tldc 0\n";
            output = output + "\tgoto L_"+Integer.toString(curLabel)+"\n";
            curLabel ++;
            output = output + "\tL_"+Integer.toString(curLabel-2)+":\n";
            output = output + "\tldc 1\n";
            output = output + "\tL_"+Integer.toString(curLabel-1)+":\n";
        }
        return;
    }
    public void visit(IRMultOp o){
        Type type = o.type;

        if(type instanceof IntegerType){
            output = output + "\tiload "+o.temp1.name+"\n";
            output = output + "\tiload "+o.temp2.name+"\n";
            output = output + "\timul\n";
        }
        else if(type instanceof FloatType){
            output = output + "\tfload "+o.temp1.name+"\n";
            output = output + "\tfload "+o.temp2.name+"\n";
            output = output + "\tfmul\n";
        }else{

        }



        return;
    }
    public void visit(IROperand o){
        return;
    }
    public void visit(IRPrint p){
        output = output + "\tgetstatic java/lang/System/out Ljava/io/PrintStream;\n";
        if(p.type instanceof StringType){
            output = output + "\taload "+p.temp.name+"\n"+"\tinvokevirtual java/io/PrintStream/print(Ljava/lang/String;)V\n";
        }
        else  if(p.type instanceof IntegerType){
            output = output + "\tiload "+p.temp.name+"\n"+"\n\tinvokevirtual java/io/PrintStream/print(I)V\n";
        }
        else  if(p.type instanceof FloatType){
            output = output + "\tfload "+p.temp.name+"\n"+"\n\tinvokevirtual java/io/PrintStream/print(F)V\n";
        }
        else  if(p.type instanceof CharType){
            output = output + "\tiload "+p.temp.name+"\n"+"\n\tinvokevirtual java/io/PrintStream/print(C)V\n";
        }
        else  if(p.type instanceof BooleanType){
            output = output + "\tiload "+p.temp.name+"\n"+"\n\tinvokevirtual java/io/PrintStream/print(Z)V\n";
        }
        return;
    }
    public void visit(IRPrintln p){
        output = output + "\tgetstatic java/lang/System/out Ljava/io/PrintStream;\n";
        if(p.type instanceof StringType){
            output = output + "\taload "+p.temp.name+"\n"+"\n\tinvokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n";
        }
        else  if(p.type instanceof IntegerType){
            output = output + "\tiload "+p.temp.name+"\n"+"\n\tinvokevirtual java/io/PrintStream/println(I)V\n";
        }
        else  if(p.type instanceof FloatType){
            output = output + "\tfload "+p.temp.name+"\n"+"\n\tinvokevirtual java/io/PrintStream/println(F)V\n";
        }
        else  if(p.type instanceof CharType){
            output = output + "\tiload "+p.temp.name+"\n"+"\n\tinvokevirtual java/io/PrintStream/println(C)V\n";
        }
        else  if(p.type instanceof BooleanType){
            output = output + "\tiload "+p.temp.name+"\n"+"\n\tinvokevirtual java/io/PrintStream/println(Z)V\n";
        }
        return;
    }
    public void visit(IRProgram p){
        return;
    }
    public void visit(IRReturn p){
        if(p.temp == null){
            output = output + "\treturn\n";
        }else{ 
            Type type = p.temp.type;
            if(type instanceof StringType){

            }
            else if(type instanceof IntegerType){
                output = output + "\tiload "+p.temp.name+"\n";
                output = output + "\tireturn\n";
            }
            else if(type instanceof FloatType){
                output = output + "\tfload "+p.temp.name+"\n";
                output = output + "\tfreturn\n";
            }
            else if(type instanceof CharType){
                output = output + "\tiload "+p.temp.name+"\n";
                output = output + "\tireturn\n";
            }
            else if(type instanceof StringType){
                output = output + "\taload "+p.temp.name+"\n";
                output = output + "\tareturn\n";
            }
            else if(type instanceof BooleanType){
                output = output + "\tiload "+p.temp.name+"\n";
                output = output + "\tireturn\n";
            }
            else if(type instanceof ArrayType){
                output = output + "\taload "+p.temp.name+"\n";
                output = output + "\tareturn\n";
            }

        }

        return;
    }
    public void visit(IRSubOp o){
        Type type = o.type;
        String n1 = o.temp1.name;
        String n2 = o.temp2.name;

        if(type instanceof IntegerType){
            output = output + "\tiload "+n1+"\n";
            output = output + "\tiload "+n2+"\n";
            output = output + "\tisub\n";
        }
        else if(type instanceof FloatType){
            output = output + "\tfload "+n1+"\n";
            output = output + "\tfload "+n2+"\n";
            output = output + "\tfsub\n";
        }
        else if(type instanceof CharType){
            output = output + "\tiload "+n1+"\n";
            output = output + "\tiload "+n2+"\n";
            output = output + "\tisub\n";
            output = output + "\ti2c\n";
        }
        // TO DO add string addition
        return;
    }
    public void visit(IRUnaryOp o){
        return;
    }
    public void visit(IRUnconditionalGoTo g){
        output = output + "\tgoto L"+g.label.name+"\n";
        return;
    }
    public void visit(Label l){
        output = output + "L"+l.name+":\n";
        return;
    }
    public void visit(Temp t){
        if(t.type instanceof StringType){
            output = output + "\taload ";
        }
        
        else if(t.type instanceof IntegerType){
            output = output + "\tiload ";
        }
        
        else if(t.type instanceof FloatType){
            output = output + "\tfload ";
        }
        
        else if(t.type instanceof CharType){
            output = output + "\tiload ";
        }
        
        else if(t.type instanceof BooleanType){
            output = output + "\tiload ";
        }
        
        else if(t.type instanceof ArrayType){
            output = output + "\taload ";
        }
        
        output = output + t.name + "\n";
        return;
    }
}