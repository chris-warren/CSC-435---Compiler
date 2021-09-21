package AST;

public class BrackExp extends Expr{
    public int line;
	public int offset;

    public Expr expr;

    public BrackExp(){
        line = -1;
        offset = -1;
    }
    public BrackExp(Expr e){
        line = -1;
        offset = -1;
        expr = e;
    }

    public BrackExp(Expr e, int l, int o){
        line = l;
        offset = o;
        expr = e;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }


}