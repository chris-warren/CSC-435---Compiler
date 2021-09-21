package TYPES;
import AST.*;

public class ArrayType extends Type {

    public int size;
    public Type t;

    public ArrayType(Type ty, int s){
        t = ty;
        size = s;
    }

    public String str(){
        return t.str()+"["+size+"]";
    }

    public String toShortString(){
        return t.toShortString();
    }    

}