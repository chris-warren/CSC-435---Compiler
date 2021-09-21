package AST;

public class IfElseStatement extends Statement{
    public int line;
	public int offset;

    public Expr expr;

    public Block ifBlock;
    public Block elseBlock;

    public IfElseStatement(){
        line = -1;
        offset = -1;
    }

    public IfElseStatement(Expr e, Block b1, Block b2){
        line = -1;
        offset = -1;
        expr = e;
        ifBlock = b1;
        elseBlock = b2;
    }

    public IfElseStatement(Expr e, Block b1, Block b2, int l, int o){
        line = l;
        offset = o;
        expr = e;
        ifBlock = b1;
        elseBlock = b2;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}