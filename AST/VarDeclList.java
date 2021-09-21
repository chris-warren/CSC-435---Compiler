package AST;
import java.util.ArrayList;

public class VarDeclList{
    public int line;
	public int offset;

    public ArrayList<VarDecl> vList;

    public VarDeclList(){
        line = -1;
        offset = -1;
    }

    public VarDeclList(ArrayList<VarDecl> l){
        line = -1;
        offset = -1;
        vList = l;
    }

    public VarDeclList(ArrayList<VarDecl> vl, int l, int o){
        line = l;
        offset = o;
        vList = vl;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}