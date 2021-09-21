package AST;

public class BooleanLiteral extends Expr{
    public int line;
	public int offset;

    public boolean val;

    public BooleanLiteral(){
        line = -1;
        offset = -1;
    }

    public BooleanLiteral(boolean b){
        line = -1;
        offset = -1;
        val = b;
    }

    public BooleanLiteral(boolean b, int l, int o){
        line = l;
        offset = o;
        val = b;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}