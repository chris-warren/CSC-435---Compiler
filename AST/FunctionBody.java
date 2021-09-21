package AST;
import java.util.ArrayList;

public class FunctionBody{
    public int line;
	public int offset;

    public VarDeclList varDecList;
    public StatementList sList;

    public FunctionBody(){
        line = -1;
        offset = -1;
    }

    public FunctionBody(VarDeclList vdl, StatementList sl){
        line = -1;
        offset = -1;
        varDecList = vdl;
        sList = sl;
    }

    public FunctionBody(VarDeclList vdl, StatementList sl, int l, int o){
        line = l;
        offset = o;
        varDecList = vdl;
        sList = sl;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}