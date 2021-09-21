package AST;

public class ArrayAssignment extends Statement{
    public int line;
	public int offset;

    public ArrayRef array;
    public Expr expr;

    public ArrayAssignment(){
        line = -1;
        offset = -1;
    }
    public ArrayAssignment(ArrayRef a, Expr e){
        line = -1;
        offset = -1;
        array = a;
        expr = e;
    }

    public ArrayAssignment(ArrayRef a, Expr e, int l, int o){
        line = l;
        offset = o;
        array = a;
        expr = e;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }
}