package AST;

public class Expr{
    public int line;
	public int offset;

    public Expr(){
        line = -1;
        offset = -1;
    }

    public Expr(int l, int o){
        line = l;
        offset = o;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }



}