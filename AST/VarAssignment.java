package AST;

public class VarAssignment{
    public int line;
	public int offset;

    public Id id;
    public Expr expr;

    public VarAssignment(){
        line = -1;
        offset = -1;
    }
    public VarAssignment(ArrayRef a, Expr e){
        line = -1;
        offset = -1;
        array = a;
        expr = e;
    }

    public VarAssignment(ArrayRef a, Expr e, int l, int o){
        line = l;
        offset = o;
        array = a;
        expr = e;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }
}