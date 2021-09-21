package AST;
import java.util.ArrayList;

public class StatementList{
    public int line;
	public int offset;

    public ArrayList<Statement> sList;

    public StatementList(){
        sList = new ArrayList<Statement>();
    }

    public StatementList(ArrayList<Statement> l){
        sList = l;
    }

    public StatementList(ArrayList<Statement> sl, int l, int o){
        line = l;
        offset = o;
        sList = sl;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}