package AST;

public class AddExpr extends Expr{
    public int line;
	public int offset;
    public Expr e1;
    public Expr e2;
    public Boolean isMinus;

	public AddExpr(){
        line = -1;
        offset = -1;
    }

    public AddExpr(Expr ex1,Expr ex2, Boolean b){
        line = -1;
        offset = -1;
        e1 = ex1;
        e2 = ex2;
        isMinus = b;
    }
    public AddExpr(Expr ex1,Expr ex2, Boolean b, int l, int o){
        line = l;
        offset = o;
        e1 = ex1;
        e2 = ex2;
        isMinus = b;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}