package AST;
import TYPES.*;

public interface Visitor<T>
{
    public T visit (AssignmentStatement e);
    public T visit (ArrayAssignment e);
    public T visit (AddExpr e);
    public T visit (ArrayRef a);
    public T visit (Block b);
    public T visit (BooleanLiteral b);
    public T visit (BrackExp e);
    public T visit (CharacterLiteral c);
    public T visit (CompareExpr e);
    public T visit (Declaration d);
    public T visit (EqualityExp e);
    public T visit (Expr e);
    public T visit (ExprStatement e);
    public T visit (ExprList e);
    public T visit (FloatLiteral f);
    public T visit (FormalParameter p);
    public T visit (FormalParameterList p);
    public T visit (FuncCall f);
    public T visit (Function f);
    public T visit (FunctionBody f);
    public T visit (FunctionDecl f);
    public T visit (Id i);
    public T visit (IfStatement s);
    public T visit (IfElseStatement s);
    public T visit (IntLiteral i);
    public T visit (MultExpr e);
    public T visit (PrintLnStatement s);
    public T visit (PrintStatement s);
    public T visit (Program p);
    public T visit (ReturnStatement s);
    public T visit (Statement s);
    public T visit (StatementList s);
    public T visit (StringLiteral s);
    public T visit (TypeNode t);
    public T visit (VarDecl v);
    public T visit (VarDeclList v);
    public T visit (WhileStatement s);

    //types
    //public T visit (ArrayType t);
    //public T visit (BooleanType t);
    //public T visit (CharType t);
    //public T visit (FloatType t);
    //public T visit (IntegerType t);
    //public T visit (StringType t);
    //public T visit (VoidType t);
    //public T visit (Type t);


}