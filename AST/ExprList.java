package AST;
import java.util.ArrayList;

public class ExprList{
    public int line;
	public int offset;

    public ArrayList<Expr> eList;

    public ExprList(ArrayList<Expr> l){
        line = -1;
        offset = -1;
        eList = l;
    }

    public ExprList(ArrayList<Expr> el, int l, int o){
        line = l;
        offset = o;
        eList = el;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}