package AST;
import java.util.ArrayList;

public class Program{
    public int line;
	public int offset;

    public ArrayList<Function> functions;

    public String name;

    /*
    public Program(){
        line = -1;
        offset = -1;
        functions = new ArrayList<Function>();
    }
    */

    public Program(ArrayList<Function> fs, String n){
        line = -1;
        offset = -1;
        functions = fs;
        name = n;
    }

    public Program(ArrayList<Function> fs, String n, int l, int o){
        line = l;
        offset = o;
        functions = fs;
        name = n;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }


}