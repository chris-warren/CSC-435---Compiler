package AST;

public class MultExpr extends Expr{
    public int line;
	public int offset;
    public Expr e1;
    public Expr e2;

    public MultExpr(){
        line = -1;
        offset = -1;
    }
    public MultExpr(Expr ex1, Expr ex2){
        line = -1;
        offset = -1;
        e1 = ex1;
        e2 = ex2;
    }

    public MultExpr(Expr ex1, Expr ex2, int l, int o){
        line = l;
        offset = o;
        e1 = ex1;
        e2 = ex2;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}