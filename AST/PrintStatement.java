package AST;

public class PrintStatement extends Statement{
    public int line;
	public int offset;

    public Expr expr;

    public PrintStatement(){
        line = -1;
        offset = -1;

    }

    public PrintStatement(Expr e){
        line = -1;
        offset = -1;
        expr = e;
    }

    public PrintStatement(Expr e, int l, int o){
        line = l;
        offset = o;
        expr = e;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }
}