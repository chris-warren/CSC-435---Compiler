package AST;

public class FuncCall extends Expr{
    public int line;
	public int offset;

    public Id id;
    public ExprList eList;

    public FuncCall(){
        line = -1;
        offset = -1;
    }

    public FuncCall(Id i, ExprList l){
        line = -1;
        offset = -1;
        id = i;
        eList = l;
    }

    public FuncCall(Id i, ExprList el, int l, int o){
        line = l;
        offset = o;
        id = i;
        eList = el;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}