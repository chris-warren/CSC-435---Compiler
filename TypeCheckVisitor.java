import AST.*;
import TYPES.*;
import Exception.*;
import Environment.*;
import java.lang.Exception.*;
import java.io.*;

public class TypeCheckVisitor implements Visitor<Type>{



    ListEnvironment<String, FunctionDecl> fEnv;
    ListEnvironment<String, Type> vEnv;
    String curFun;
    Type curFunType;


    public TypeCheckVisitor(){
        fEnv = new ListEnvironment<String, FunctionDecl>();
        //vEnv = new ListEnvironment();
    }


    public Type visit (AssignmentStatement e)
    {
        Type t1 = e.id.accept(this);
        Type t2 = e.expr.accept(this);
        if(!(t1.equals(t2))){
            throw new SemanticException("Type mismatch, expecting "+t1.str()+" got "+t2.str(), e.line, e.offset);
        }
        return t2;
    }
    public Type visit (ArrayAssignment e)
    {
        Type t1 = e.expr.accept(this);
        Type t2 = e.array.accept(this);
        if(!(t2.equals(t1))){
            throw new SemanticException("Type mismatch, expecting "+t1.str()+" got "+t2.str(), e.line, e.offset);
        }
        return t1;
    }
    public Type visit (AddExpr e)
    {
        Type t1 = e.e1.accept(this);
        Type t2;
        if(e.e2 != null){
            //System.out.println(t1);
            t2 = e.e2.accept(this);
            //System.out.println(t2);
            if(!(t1.equals(t2))){
                throw new SemanticException("Type mismatch, expecting "+t1.str()+" got "+t2.str(), e.line, e.offset);
            }
            if(e.isMinus){
                if(!(t1.equals(new IntegerType()) || t1.equals(new FloatType()) || t1.equals(new CharType()) || t2.equals(new FloatType()) || t2.equals(new IntegerType()) || t2.equals(new CharType()))){
                    throw new SemanticException("Type not compatible with minus op", e.line, e.offset);
                }
            }else{
                if(!(t1.equals(new IntegerType()) || t1.equals(new FloatType()) || t1.equals(new CharType()) || t1.equals(new StringType()) || t2.equals(new FloatType()) || t2.equals(new IntegerType()) || t2.equals(new CharType()) || t2.equals(new StringType()))){
                    throw new SemanticException("Type not compatible with plus op", e.line, e.offset);
                }
            }
        }
        return t1;
    }

    public Type visit (ArrayRef a)
    {
        if(!(a.expr.accept(this).equals(new IntegerType()))){
            throw new SemanticException("Array index must be Integer", a.line, a.offset);
        }
        return ((ArrayType)vEnv.lookup(a.id.id)).t;
    }

    public Type visit (Block b)
    {
        b.sList.accept(this);
        return null;
    }
    public Type visit (BooleanLiteral b)
    {
        return new BooleanType();
    }
    public Type visit (BrackExp e)
    {
        return e.expr.accept(this);
    }
    public Type visit (CharacterLiteral c)
    {
        return new CharType();
    }
    public Type visit (CompareExpr e)
    {
        Type t1 = e.e1.accept(this);
        Type t2 = e.e2.accept(this);

        if(t1.equals(new VoidType())){
            throw new SemanticException("Type not compatible with less than op", e.line, e.offset);
        }
        if(!(t1.equals(t2))){
            throw new SemanticException("Type mismatch, expecting "+t1.str()+" got "+t2.str(), e.line, e.offset);
        }
        return new BooleanType();
    }
    public Type visit (Declaration d)
    {
        return d.type.t;
    }
    public Type visit (EqualityExp e)
    {
        Type t1 = e.e1.accept(this);
        Type t2 = e.e2.accept(this);

        if(t1.equals(new VoidType())){
            throw new SemanticException("Type not compatible with equality op", e.line, e.offset);
        }
        if(!(t1.equals(t2))){
            throw new SemanticException("Type mismatch, expecting "+t1.str()+" got "+t2.str(), e.line, e.offset);
        }
        return new BooleanType();
    }
    public Type visit (Expr e)
    {
        return null;
    }
    public Type visit (ExprStatement e)
    {
        return e.expr.accept(this);
    }
    public Type visit (ExprList e)
    {
        return null;
    }
    public Type visit (FloatLiteral f)
    {
        return new FloatType();
    }
    public Type visit (FormalParameter p)
    {
        return null;
    }
    public Type visit (FormalParameterList p)
    {
        for(int i = 0; i<p.params.size(); i++){
            String pName = p.params.get(i).dec.id.id;
            Type pType = p.params.get(i).dec.type.t;
            if(vEnv.inCurrentScope(pName)){
                throw new SemanticException("Duplicate param names", p.params.get(i).line, p.params.get(i).offset);
            }
            vEnv.add(pName, pType);
            //checking for void params
            if(p.params.get(i).dec.type.t instanceof VoidType){
                throw new SemanticException("Void type parameter", p.params.get(i).line, p.params.get(i).offset);
            }
        }
        return null;
    }
    public Type visit (FuncCall f)
    {
        Type t;
        FunctionDecl fd;
        if(!fEnv.inCurrentScope(f.id.id)){
            throw new SemanticException("function not defined", f.id.line, f.id.offset);
        }else{
            fd = (FunctionDecl)fEnv.lookup(f.id.id);
            //wrong number of params
            if(f.eList.eList.size() != fd.params.params.size()){
                throw new SemanticException("wrong number of parameters", f.id.line, f.id.offset);
            }else{
                for(int i = 0; i < fd.params.params.size(); i++){
                    if(!(fd.params.params.get(i).dec.type.t.equals(f.eList.eList.get(i).accept(this)))){
                        throw new SemanticException("Wrong parameter type ", f.line, f.offset);
                    }
                }
            }
        }

        return fd.type.t;
    }
    public Type visit (Function f)
    {
        vEnv = new ListEnvironment<String, Type>();
        curFun = f.declaration.id.id;
        curFunType = f.declaration.type.t;
        f.declaration.accept(this);
        f.body.accept(this);
        //System.out.println(vEnv.toString());
        return null;
    }
    public Type visit (FunctionBody f)
    {
        f.varDecList.accept(this);
        f.sList.accept(this);
        return null;
    }
    public Type visit (FunctionDecl f)
    {
        Type fType = f.type.t;
        curFun = f.id.id;
        curFunType = fType;

        f.params.accept(this);
        return null;
    }
    public Type visit (Id i)
    {
        if(!vEnv.inCurrentScope(i.id)){
            throw new SemanticException("var not defined", i.line, i.offset);
        }

        return (Type)vEnv.lookup(i.id);
    }
    public Type visit (IfStatement s)
    {
        if(!(s.expr.accept(this).equals(new BooleanType()))){
            throw new SemanticException("if exp must be boolean", s.line, s.offset);
        }
        
        s.block.accept(this);
        return null;
    }
    public Type visit (IfElseStatement s)
    {
        if(!(s.expr.accept(this).equals(new BooleanType()))){
            throw new SemanticException("if exp must be boolean", s.line, s.offset);
        }
        s.ifBlock.accept(this);
        s.elseBlock.accept(this);
        return null;
    }
    public Type visit (IntLiteral i)
    {
        return new IntegerType();
    }
    public Type visit (MultExpr e)
    {
        Type t1 = e.e1.accept(this);
        Type t2 = e.e2.accept(this);

        if(!(t1.equals(new IntegerType()) || t1.equals(new FloatType()) || t2.equals(new FloatType()) || t2.equals(new IntegerType()))){
            throw new SemanticException("Type not compatible with mult op", e.line, e.offset);
        }
        if(!(t1.equals(t2))){
            throw new SemanticException("Type mismatch, expecting "+t1.str()+" got "+t2.str(), e.line, e.offset);
        }
        return t1;
    }
    public Type visit (PrintLnStatement s)
    {
        Type t = s.expr.accept(this);
        if(!(t.equals(new IntegerType()) || t.equals(new FloatType()) || t.equals(new CharType()) || t.equals(new StringType()) || t.equals(new BooleanType()))){
            throw new SemanticException("Type not compatible with println", s.line, s.offset);
        }
        return null;
    }
    public Type visit (PrintStatement s)
    {
        Type t = s.expr.accept(this);
        if(!(t.equals(new IntegerType()) || t.equals(new FloatType()) || t.equals(new CharType()) || t.equals(new StringType()) || t.equals(new BooleanType()))){
            throw new SemanticException("Type not compatible with print", s.line, s.offset);
        }
        return null;
    }
    public Type visit (Program p)
    {
        Boolean hasMain = false;
        int mainIndex = -1;

        for(int i = 0; i < p.functions.size(); i++){
            //checking if function is already in env
            String fName = p.functions.get(i).declaration.id.id;
            if(fEnv.inCurrentScope(fName)){
                throw new SemanticException("Duplicate function names", p.functions.get(i).line, p.functions.get(i).offset);
            }
            fEnv.add(fName, p.functions.get(i).declaration);

            //checking for main function
            if(fName.equals("main")){
                hasMain = true;
                mainIndex = i;
            }
        }
        if(!hasMain){
            throw new SemanticException("no main method", 0, 0);
        }else{
            //checking main has no params
            if(p.functions.get(mainIndex).declaration.params.params.size()>0){
                throw new SemanticException("main method has parameters", p.functions.get(mainIndex).line, p.functions.get(mainIndex).offset);
            }
            //checking main is void
            VoidType tempVoid = new VoidType();
            if(!(p.functions.get(mainIndex).declaration.type.t.equals(tempVoid))){
                throw new SemanticException("main method is not of type void", p.functions.get(mainIndex).line, p.functions.get(mainIndex).offset);
            }
        }

        //visit functions
        //System.out.println(fEnv.toString());
        for(int i = 0; i < p.functions.size(); i++){
            p.functions.get(i).accept(this);
        }
        return null;
    }
    public Type visit (ReturnStatement s)
    {
        if(!(s.expr.accept(this).equals(curFunType))){
            throw new SemanticException("Type of return statement does not match function type", s.line, s.offset);
        }
        return s.expr.accept(this);
    }
    public Type visit (Statement s)
    {
        return null;
    }
    public Type visit (StatementList s)
    {
        for(int i = 0; i < s.sList.size(); i++){
            s.sList.get(i).accept(this);
            
        }
        return null;
    }
    public Type visit (StringLiteral s)
    {
        return new StringType();
    }
    public Type visit (TypeNode t)
    {
        return t.t;
    }
    public Type visit (VarDecl v)
    {
        return null;
    }
    public Type visit (VarDeclList v)
    {
        for(int i = 0; i<v.vList.size(); i++){
            String vName = v.vList.get(i).id.id;
            Type vType = v.vList.get(i).type.t;
            if(vEnv.inCurrentScope(vName)){
                throw new SemanticException("Duplicate variable names", v.vList.get(i).line, v.vList.get(i).offset);
            }
            vEnv.add(vName, vType);
            //checking for void params
            if(vType instanceof VoidType){
                throw new SemanticException("Void type variable", v.vList.get(i).line, v.vList.get(i).offset);
            }
        }
        return null;
    }
    public Type visit (WhileStatement s)
    {
        if(!(s.expr.accept(this).equals(new BooleanType()))){
            throw new SemanticException("while exp must be boolean", s.line, s.offset);
        }
        s.block.accept(this);
        return null;
    }
}