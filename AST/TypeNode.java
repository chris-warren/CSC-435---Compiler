package AST;
import TYPES.*;


public class TypeNode{
    public int line;
	public int offset;

    public String type;
    public int size;
    public Boolean isArray;
    public Type t;


    public TypeNode(){
        line = -1;
        offset = -1;
        //type = "rip";
    }
    /*
    public TypeNode(String t, Type ty){
        line = -1;
        offset = -1;
        type = t;
        size = 1;
        isArray = false;
        t = ty;
    }

    public TypeNode(String t, int s, Type ty){
        line = -1;
        offset = -1;
        type = t;
        size = 1;
        isArray = true;
        size = s;
        t = ty;
    }
    */
    public TypeNode(Type ty){
        line = -1;
        offset = -1;
        t = ty;
    }

    public TypeNode(Type ty, int l, int o){
        line = l;
        offset = o;
        t = ty;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}