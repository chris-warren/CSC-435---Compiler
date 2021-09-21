package AST;

public class ArrayRef extends Expr{
    public int line;
	public int offset;

    public Id id;
    public Expr expr;

    public ArrayRef(Id i, Expr e){
        line = -1;
        offset = -1;
        id = i;
        expr = e;
    }

    public ArrayRef(Id i, Expr e, int l, int o){
        line = l;
        offset = o;
        id = i;
        expr = e;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }
}