package AST;

public class ReturnStatement extends Statement{
    public int line;
	public int offset;

    public Expr expr;

    public ReturnStatement(){
        line = -1;
        offset = -1;
    }

    public ReturnStatement(Expr e){
        line = -1;
        offset = -1;
        expr = e;
    }

    public ReturnStatement(Expr e, int l, int o){
        line = l;
        offset = o;
        expr = e;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}