package AST;

public class SubtractExpr extends Expr{
    public int line;
	public int offset;
    public Expr e1;
    public Expr e2;

	public SubtractExpr(){
        line = -1;
        offset = -1;
    }

    public SubtractExpr(Expr ex1,Expr ex2){
        line = -1;
        offset = -1;
        e1 = ex1;
        e2 = ex2;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}