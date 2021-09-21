package AST;

public class PrintLnStatement extends Statement{
    public int line;
	public int offset;

    public Expr expr;

    public PrintLnStatement(){
        line = -1;
        offset = -1;
    }

    public PrintLnStatement(Expr e){
        line = -1;
        offset = -1;
        expr = e;
    }

    public PrintLnStatement(Expr e, int l, int o){
        line = l;
        offset = o;
        expr = e;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}