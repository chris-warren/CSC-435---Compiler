package AST;

public class ExprStatement extends Statement{
    public int line;
	public int offset;

    public Expr expr;

    public ExprStatement(Expr e){
        line = -1;
        offset = -1;
        expr = e;
    }

    public ExprStatement(Expr e, int l, int o){
        line = l;
        offset = o;
        expr = e;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }


}