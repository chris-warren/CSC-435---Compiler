package AST;
import java.util.ArrayList;

public class FormalParameterList{
    public int line;
	public int offset;

    public ArrayList<FormalParameter> params;

    public FormalParameterList(){
        line = -1;
        offset = -1;
    }

    public FormalParameterList(ArrayList<FormalParameter> p){
        line = -1;
        offset = -1;
        params = p;
    }

    public FormalParameterList(ArrayList<FormalParameter> p, int l, int o){
        line = l;
        offset = o;
        params = p;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}