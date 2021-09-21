package AST;
import TYPES.*;

public class PrettyPrintVisitor implements Visitor<Void>{

    public int indent;

    public PrettyPrintVisitor(){
        indent = 0;
    }

    public Void printIndent(){
        for(int i = 0; i < indent; i ++){
            System.out.print("    ");
        }
        return null;
    }

    public Void visit (AssignmentStatement e){
        e.id.accept(this);
        System.out.print( "=");
        e.expr.accept(this);
        System.out.println(";");
        return null;
    }
    public Void visit (ArrayAssignment e){
        e.array.accept(this);
        System.out.print("=");
        e.expr.accept(this);
        System.out.println(";");
        return null;
    }
    public Void visit (AddExpr e){
        e.e1.accept(this);
        if(e.e2 != null){
            if(e.isMinus){
                System.out.print("-");
            }else{
                System.out.print("+");
            }
            
            e.e2.accept(this);
        } 
        return null;
    }
    public Void visit (ArrayRef a){
        a.id.accept(this);
        System.out.print("[");
        a.expr.accept(this);
        System.out.print("]");
        return null;
    }

    public Void visit (Block b){
        b.sList.accept(this);
        return null;
    }
    public Void visit (BooleanLiteral b){
        if(b.val){
            System.out.print("true");
        }else{
            System.out.print("false");
        }
        return null;
    }
    public Void visit (BrackExp e){
        System.out.print("(");
        e.expr.accept(this);
        System.out.print(")");
        //System.out.print("brackExp");
        return null;
    }
    public Void visit (CharacterLiteral c){
        System.out.print("'");
        System.out.print(c.val);
        System.out.print("'");
        return null;
    }
    public Void visit (CompareExpr e){
        e.e1.accept(this);
        if(e.e2 != null){
            System.out.print("<");
            e.e2.accept(this);
        } 
        return null;
    }
    public Void visit (Declaration d){
        d.type.accept(this);
        System.out.print(" ");
        d.id.accept(this);
        return null;
    }
    public Void visit (Expr e){
        return null;
    }
    public Void visit (ExprStatement e){
        //System.out.println("ExprSTMNT visitor");
        //System.out.println(e.expr);
        e.expr.accept(this);
        System.out.println(";");
        return null;
    }
    public Void visit (ExprList e){
        for(int i=0;i<e.eList.size(); i++){
            e.eList.get(i).accept(this);
            
            if(i<e.eList.size()-1){
                System.out.print(",");
            }
        }
        return null;
    }
    public Void visit (EqualityExp e){
        e.e1.accept(this);
        if(e.e2 != null){
            System.out.print("==");
            e.e2.accept(this);
        } 
        return null;
    }
    public Void visit (FloatLiteral f){
        System.out.print(f.val);
        return null;
    }
    public Void visit (FormalParameter p){
        //p.params.accept(this);
        //System.out.print("param");
        p.dec.accept(this);
        return null;
    }
    public Void visit (FormalParameterList p){
        //p.params.accept(this);
        for(int i=0;i<p.params.size(); i++){
            
            p.params.get(i).accept(this);
            if(i<p.params.size()-1){
                System.out.print(", ");
            }
        }
        return null;
    }
    public Void visit (FuncCall f){
        f.id.accept(this);
        System.out.print("(");
        f.eList.accept(this);
        System.out.print(")");
        return null;
    }
    public Void visit (Function f){
        //System.out.println(f.name);
        f.declaration.accept(this);
        f.body.accept(this);
        System.out.println("}");
        return null;
    }
    public Void visit (FunctionBody f){
        indent++;
        f.varDecList.accept(this);
        if(f.varDecList.vList.size() > 0 && f.sList.sList.size() > 0){
            System.out.println();
        }
        
        f.sList.accept(this);
        indent--;
        return null;
    }
    public Void visit (FunctionDecl f){
        //System.out.println(f.tester);
        f.type.accept(this);
        System.out.print(" ");
        f.id.accept(this);
        System.out.print(" (");
        //System.out.println(f.params);
        f.params.accept(this);
        //f.params.accept(this);
        System.out.println(")");
        printIndent();
        System.out.println("{");
        return null;
    }
    public Void visit (Id i){
        String name = i.id;
        System.out.print(name);
        return null;
    }
    public Void visit (IfStatement s){
        System.out.print("if (");
        s.expr.accept(this);
        System.out.println(")");
        printIndent();
        System.out.println("{");
        indent++;
        s.block.accept(this);
        indent--;
        //System.out.print(", ");
        printIndent();
        System.out.println("}");
        return null;
    }
    public Void visit (IfElseStatement s){
        System.out.print("if (");
        s.expr.accept(this);
        System.out.println(")");
        printIndent();
        System.out.println("{");
        indent++;
        s.ifBlock.accept(this);
        indent--;
        printIndent();
        System.out.println("}");
        printIndent();
        System.out.println("else");
        printIndent();
        System.out.println("{");
        indent++;
        s.elseBlock.accept(this);
        indent--;
        printIndent();
        System.out.println("}");
        return null;
    }
    public Void visit (IntLiteral i){
        System.out.print(i.val);
        return null;
    }

    public Void visit (MultExpr e){
        e.e1.accept(this);
        if(e.e2 != null){
            System.out.print("*");
            e.e2.accept(this);
        } 
        return null;
    }
    public Void visit (PrintLnStatement s){
        System.out.print("println ");
        s.expr.accept(this);
        System.out.println(";");
        return null;
    }
    public Void visit (PrintStatement s){
        System.out.print("print ");
        s.expr.accept(this);
        System.out.println(";");
        return null;
    }
    public Void visit (Program p){
        //System.out.println(p.name);
        for(int i=0;i<p.functions.size(); i++){
            
            p.functions.get(i).accept(this);
            System.out.println();
        }
        return null;
    }
    public Void visit (ReturnStatement s){
        System.out.print("return ");
        s.expr.accept(this);
        System.out.println(";");
        return null;
    }
    public Void visit (Statement s){
        System.out.println(";");
        return null;
    }
    public Void visit (StatementList s){
        for(int i=0;i<s.sList.size(); i++){
            printIndent();
            s.sList.get(i).accept(this);
            //System.out.println("");
        }
        return null;
    }
    public Void visit (StringLiteral s){
        System.out.print('"');
        System.out.print(s.val);
        System.out.print('"');
        return null;
    }
    public Void visit (TypeNode t){
        /*
        String type = t.type;
        if(t.isArray){
            System.out.print(type + "[" + t.size + "] ");
        }else{
            System.out.print(type + " ");
        }
        */
        //System.out.println(t.t);
        //t.t.accept(this);
        System.out.print(t.t.str());
        return null;
    }
    public Void visit (VarDecl v){
        v.type.accept(this);
        System.out.print(" ");
        v.id.accept(this);
        return null;
    }
    public Void visit (VarDeclList v){
        for(int i=0;i<v.vList.size(); i++){
            printIndent();
            v.vList.get(i).accept(this);
            System.out.println(";");
        }
        return null;
    }
    public Void visit (WhileStatement s){
        System.out.print("while (");
        s.expr.accept(this);
        System.out.println(")");
        printIndent();
        System.out.println("{");
        indent++;
        s.block.accept(this);
        indent--;
        printIndent();
        System.out.println("}");
        return null;
    }

    //types
    //public Void visit (ArrayType t){
    //    t.t.accept(this);
    //    System.out.print("[");
    //    System.out.print(t.size);
    //    System.out.print("]");
    //    return null;
    //}
    //public Void visit (BooleanType t){
    //    System.out.print("Boolean");
    //    return null;
    //}
    //public Void visit (CharType t){
    //    System.out.print("Char");
    //    return null;
    //}
    //public Void visit (FloatType t){
    //    System.out.print("Float");
    //    return null;
    //}
    //public Void visit (IntegerType t){
    //    System.out.print("Integer");
    //    return null;
    //}   
    //public Void visit (StringType t){
    //    System.out.print("String");
    //    return null;
    //}
    //public Void visit (VoidType t){
    //    System.out.print("Void");
    //    return null;
    //}
    //public Void visit (Type t){
    //    System.out.print("test");
    //    return null;
    //}

}