package AST;

public class IfStatement extends Statement{
    public int line;
	public int offset;

    public Expr expr;

    public Block block;

    public IfStatement(){
        line = -1;
        offset = -1;
    }

    public IfStatement(Expr e, Block b){
        line = -1;
        offset = -1;
        expr = e;
        block = b;
    }

    public IfStatement(Expr e, Block b, int l, int o){
        line = l;
        offset = o;
        expr = e;
        block = b;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}