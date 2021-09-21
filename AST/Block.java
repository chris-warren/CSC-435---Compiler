package AST;
import java.util.ArrayList;

public class Block{
    public int line;
	public int offset;

    public StatementList sList;


    public Block(){
        line = -1;
        offset = -1;
        sList = new StatementList();
    }

    public Block(StatementList l){
        line = -1;
        offset = -1;
        sList = l;
    }

    public Block(StatementList sl, int l, int o){
        line = l;
        offset = o;
        sList = sl;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}