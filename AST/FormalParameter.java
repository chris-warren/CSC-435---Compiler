package AST;
import java.util.ArrayList;

public class FormalParameter{
    public int line;
	public int offset;

    public Declaration dec;

    public FormalParameter(){
        line = -1;
        offset = -1;
    }

    public FormalParameter(Declaration d){
        line = -1;
        offset = -1;
        dec = d;
    }

    public FormalParameter(Declaration d, int l, int o){
        line = l;
        offset = o;
        dec = d;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}