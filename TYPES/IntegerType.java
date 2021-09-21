package TYPES;
import AST.*;

public class IntegerType extends Type {
    public IntegerType(){

    }

    public String str(){
        return "Int";
    }

    public String toShortString(){
        return "I";
    }    

}