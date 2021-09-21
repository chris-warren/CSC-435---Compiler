package TYPES;
import AST.*;

public class StringType extends Type {
    public StringType(){

    }

    public String str(){
        return "String";
    }

    public String toShortString(){
        return "U";
    }    

}