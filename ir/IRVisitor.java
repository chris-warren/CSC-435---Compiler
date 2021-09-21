
package ir;
import AST.*;
import TYPES.*;
import Exception.*;
import Environment.*;
import java.lang.Exception.*;
import java.io.*;
import ir.*;
import java.util.ArrayList;
import java.util.Objects;

public class IRVisitor implements Visitor<Temp>{

    public TempFactory tempFactory;
    public ArrayList<Instruction> iList;
    public ArrayList<IRFunction> fList;
    ListEnvironment<String, Temp> vEnv;
    ListEnvironment<String, Type> fEnv;
    public String curFun;


    public IRVisitor(){
        tempFactory = new TempFactory();
        iList = new ArrayList<Instruction>();
        fList = new ArrayList<IRFunction>();
        vEnv = new ListEnvironment<String, Temp>();
        fEnv = new ListEnvironment<String, Type>();

    }


    public Temp visit (AssignmentStatement e)
    {
        String id = e.id.id;
        Temp t1 = e.id.accept(this);
        Temp t2 = e.expr.accept(this);
        IRAssignment a = new IRAssignment(t1, t2);
        iList.add(a);
        return null;
    }
    public Temp visit (ArrayAssignment e)
    {
        ArrayRef aref = e.array;
        Temp t1 = aref.id.accept(this);
        Temp t2 = aref.expr.accept(this);
        Type type = t1.type;
        IRArrayReference ar = new IRArrayReference(type, t1.toString(), "TEMP", t1, t2);

        
        //Temp ar = e.array.accept(this);
        Temp op = e.expr.accept(this);
        IRAssignment a = new IRAssignment(ar, op);
        iList.add(a);
        return null;
    }
    public Temp visit (AddExpr e)
    {
        Temp t1 = e.e1.accept(this);
        Type type = t1.type;
        if(e.e2 != null){
            Temp t2 = e.e2.accept(this);
            if(e.isMinus){
                return subHelper(t1, t2, type);
            }else{
                return addHelper(t1, t2, type);
            }
        } 
        return null;
    }

    public Temp subHelper(Temp t1, Temp t2, Type type){
        Temp result = tempFactory.createTemp(type, "TEMP");
        IRSubOp sub = new IRSubOp(type, t1, t2);
        IRAssignment a = new IRAssignment(result, sub);
        iList.add(a);
        return result;
    }

    public Temp addHelper(Temp t1, Temp t2, Type type){
        Temp result = tempFactory.createTemp(type, "TEMP");
        IRAddOp sub = new IRAddOp(type, t1, t2);
        IRAssignment a = new IRAssignment(result, sub);
        iList.add(a);
        return result;
    }

    public Temp visit (ArrayRef a)
    {
        Temp t1 = a.id.accept(this);
        Temp t2 = a.expr.accept(this);
        Type type = ((ArrayType)t1.type).t;
        IRArrayReference ar = new IRArrayReference(type, t1.toString(), "TEMP", t1, t2);
        Temp t3 = tempFactory.createTemp(type, "TEMP");
        IRAssignment ira = new IRAssignment(t3, ar);
        iList.add(ira);
        return t3;
    }

    public Temp visit (Block b)
    {
        b.sList.accept(this);
        return null;
    }
    public Temp visit (BooleanLiteral b)
    {
        Temp temp = tempFactory.createTemp(new BooleanType(), "TEMP");
        Type type = temp.type;
        IRConst bool = new IRConst(type);
        bool.val = b.val;
        IRAssignment a = new IRAssignment(temp, bool);
        iList.add(a);
        return temp;
    }
    public Temp visit (BrackExp e)
    {
        return e.expr.accept(this);
    }
    public Temp visit (CharacterLiteral c)
    {
        Temp temp = tempFactory.createTemp(new CharType(), "TEMP");
        Type type = temp.type;
        IRConst constant = new IRConst(type);
        constant.val = c.val;
        IRAssignment a = new IRAssignment(temp, constant);
        iList.add(a);
        return temp;
    }
    public Temp visit (CompareExpr e)
    {
        Temp t1 = e.e1.accept(this);
        if(e.e2 != null){
            Temp t2 = e.e2.accept(this);
            Type type = t1.type;
            Temp t3 = tempFactory.createTemp(new BooleanType(), "TEMP");
            IRLessThanOp op = new IRLessThanOp(type, t1, t2);
            IRAssignment a = new IRAssignment(t3, op);
            iList.add(a);
            return t3;
        } 
        return t1;
    }
    public Temp visit (Declaration d)
    {
        d.type.accept(this);
        d.id.accept(this);
        return null;
    }
    public Temp visit (EqualityExp e)
    {
        Temp e1 = e.e1.accept(this);
        Temp e2;
        if(e.e2 != null){
            e2 = e.e2.accept(this);
            Temp t = tempFactory.createTemp(new BooleanType(), "TEMP");
            IREqualityOp op = new IREqualityOp(e1.type, e1, e2);
            IRAssignment a = new IRAssignment(t, op);
            if(a == null){
                  System.out.println("a is null");  
            }
            iList.add(a);
            return t;
        } 
        return null;
    }
    public Temp visit (Expr e)
    {
        return null;
    }
    public Temp visit (ExprStatement e)
    {
        e.expr.accept(this);
        return null;
    }
    public Temp visit (ExprList e)
    {
        for(int i=0;i<e.eList.size(); i++){
            e.eList.get(i).accept(this);
        }
        return null;
    }
    public Temp visit (FloatLiteral f)
    {
        Temp temp = tempFactory.createTemp(new FloatType(), "TEMP");
        Type type = temp.type;
        IRConst constant = new IRConst(type);
        constant.val = f.val;
        IRAssignment a = new IRAssignment(temp, constant);
        iList.add(a);
        return temp;
    }
    public Temp visit (FormalParameter p)
    {
        p.dec.accept(this);
        Temp temp = tempFactory.createTemp(p.dec.type.t, "PARAMETER");
        vEnv.add(p.dec.id.id, temp);
        return null;
    }
    public Temp visit (FormalParameterList p)
    {
        for(int i=0;i<p.params.size(); i++){
            p.params.get(i).accept(this);
        }
    
        return null;
    }
    public Temp visit (FuncCall f)
    {
        f.id.accept(this);
        //f.eList.accept(this);
        String fName = f.id.id;
        Type rType = fEnv.lookup(fName);
        ArrayList<Temp> fArgs = new ArrayList<Temp>();
        for(int i = 0; i < f.eList.eList.size(); i++){
            Temp t = f.eList.eList.get(i).accept(this);
            fArgs.add(t);
        }

        if(rType instanceof VoidType){
            IRFuncCallInstruction fCall = new IRFuncCallInstruction(fName, fArgs, rType);
            iList.add(fCall);
            return null;
        }else{
            IRFuncCallOp fCall = new IRFuncCallOp(fName, fArgs, rType);
            Temp temp = tempFactory.createTemp(rType, "TEMP");
            IRAssignment a = new IRAssignment(temp, fCall);
            iList.add(a);
            return temp;
        }
    }
    public Temp visit (Function f)
    {
        curFun = f.declaration.id.id;
        
        //new temp factory / instruction list for each function
        tempFactory = new TempFactory();
        iList = new ArrayList<Instruction>();
        vEnv = new ListEnvironment<String, Temp>();

        //function declaration info
        String name = f.declaration.id.id;
        Type r = f.declaration.type.t;

        //function params
        ArrayList<Type> pList = new ArrayList<Type>();
        FormalParameterList ps = f.declaration.params;
        for(int i = 0; i < ps.params.size(); i++){
            pList.add(ps.params.get(i).dec.type.t);
        }


        IRFunction func = new IRFunction(name, r, pList);

        f.declaration.accept(this);
        f.body.accept(this);


        //store instructions / temps in funciton and add to function list
        func.iList = iList;
        func.tempFactory = tempFactory;
        fList.add(func);

        System.out.println(vEnv.toString());
        return null;
    }
    public Temp visit (FunctionBody f)
    {
        f.varDecList.accept(this);
        f.sList.accept(this);
        iList.add(new IRReturn());
        return null;
    }
    public Temp visit (FunctionDecl f)
    {
        f.type.accept(this);
        f.id.accept(this);
        f.params.accept(this);
        return null;
    }
    public Temp visit (Id i)
    {
        String id = i.id;
        Temp temp = vEnv.lookup(id);
        return temp;
    }
    public Temp visit (IfStatement s)
    {
        Label label = tempFactory.createLabel();
        Temp conditional = s.expr.accept(this);
        Temp negExpr = tempFactory.createTemp(new BooleanType(), "TEMP");
        Type type = new BooleanType();
        IRBoolNeg negation = new IRBoolNeg(conditional, type);
        IRAssignment assignment = new IRAssignment(negExpr, negation);
        iList.add(assignment);
        IRConditionalGoTo cGoTo = new IRConditionalGoTo(negExpr, label);
        iList.add(cGoTo);
        s.block.accept(this);
        iList.add(label);
        return null;
    }
    public Temp visit (IfElseStatement s)
    {
        Label l1 = tempFactory.createLabel();
        Label l2 = tempFactory.createLabel();
        Temp conditional = s.expr.accept(this);

        // might need to fix in the event that conditional is a local
        Temp negExpr = tempFactory.createTemp(new BooleanType(), "TEMP");
        Type type = new BooleanType();
        IRBoolNeg negation = new IRBoolNeg(conditional, type);
        IRAssignment assignment = new IRAssignment(negExpr, negation);
        iList.add(assignment);
        IRConditionalGoTo cGoTo = new IRConditionalGoTo(negExpr, l1);
        iList.add(cGoTo);
        s.ifBlock.accept(this);
        
        IRUnconditionalGoTo goTo = new IRUnconditionalGoTo(l2);
        iList.add(goTo);

        iList.add(l1);

        s.elseBlock.accept(this);
        iList.add(l2);
        return null;
    }
    public Temp visit (IntLiteral i)
    {
        Temp temp = tempFactory.createTemp(new IntegerType(), "TEMP");
        Type type = temp.type;
        IRConst c = new IRConst(type);
        c.val = i.val;
        IRAssignment a = new IRAssignment(temp, c);
        iList.add(a);
        return temp;
    }
    public Temp visit (MultExpr e)
    {
        Temp e1 = e.e1.accept(this);
        Temp e2;
        if(e.e2 != null){
            e2 = e.e2.accept(this);
            Temp t = tempFactory.createTemp(e1.type, "TEMP");
            IRMultOp op = new IRMultOp(e1.type, e1, e2);
            IRAssignment a = new IRAssignment(t, op);
            if(a == null){
                  System.out.println("a is null");  
            }
            iList.add(a);
            return t;
        } 
        System.out.println("returned null in mult exp");
        return null;
    }
    public Temp visit (PrintLnStatement s)
    {
        Temp temp = s.expr.accept(this);
        Type type = temp.type;
        IRPrintln print = new IRPrintln(temp, type);
        iList.add(print);
        return null;
    }
    public Temp visit (PrintStatement s)
    {
        Temp temp = s.expr.accept(this);
        Type type = temp.type;
        IRPrint print = new IRPrint(temp, type);
        iList.add(print);
        return null;
    }
    public Temp visit (Program p)
    {

        for(int i=0;i<p.functions.size(); i++){
            String fName = p.functions.get(i).declaration.id.id;

            fEnv.add(fName, p.functions.get(i).declaration.type.t);

        }

        
        for(int i=0;i<p.functions.size(); i++){
            p.functions.get(i).accept(this);
        }
        return null;
    }
    public Temp visit (ReturnStatement s)
    {
        Temp temp = null;
        if(s.expr != null){
            temp = s.expr.accept(this);
        }
        IRReturn r = new IRReturn(temp);
        iList.add(r);
        return null;
    }
    public Temp visit (Statement s)
    {
        return null;
    }
    public Temp visit (StatementList s)
    {
        for(int i=0;i<s.sList.size(); i++){
            s.sList.get(i).accept(this);
        }
        return null;
    }
    public Temp visit (StringLiteral s)
    {
        Temp temp = tempFactory.createTemp(new StringType(), "TEMP");
        Type type = temp.type;
        IRConst string = new IRConst(type);
        string.val = s.val;
        IRAssignment a = new IRAssignment(temp, string);
        iList.add(a);
        return temp;
    }
    public Temp visit (TypeNode t)
    {
        return null;
    }
    public Temp visit (VarDecl v)
    {

        v.type.accept(this);
        v.id.accept(this);
        Temp temp = tempFactory.createTemp(v.type.t, "LOCAL");
        vEnv.add(v.id.id, temp);
        Type type = v.type.t;
        if(type instanceof ArrayType){
            IRArrayInitialization ar = new IRArrayInitialization((ArrayType)type);
            IRAssignment a = new IRAssignment(temp, ar);
            iList.add(a);
        }
        return null;
    }
    public Temp visit (VarDeclList v)
    {
        for(int i=0;i<v.vList.size(); i++){
            v.vList.get(i).accept(this);
        }
        return null;
    }
    public Temp visit (WhileStatement s)
    {
        Label l1 = tempFactory.createLabel();
        Label l2 = tempFactory.createLabel();
        iList.add(l1);
        Temp conditional = s.expr.accept(this);
        Temp negExpr = tempFactory.createTemp(new BooleanType(), "TEMP");
        Type type = new BooleanType();
        IRBoolNeg negation = new IRBoolNeg(conditional, type);
        IRAssignment assignment = new IRAssignment(negExpr, negation);
        iList.add(assignment);
        IRConditionalGoTo cGoTo = new IRConditionalGoTo(negExpr, l2);
        iList.add(cGoTo);
        s.block.accept(this);
        IRUnconditionalGoTo goTo = new IRUnconditionalGoTo(l1);
        iList.add(goTo);

        iList.add(l2);

        return null;
    }
}