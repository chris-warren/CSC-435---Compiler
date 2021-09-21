package TYPES;
import AST.*;

public class VoidType  extends Type {
    public VoidType(){

    }
    public String str(){
        return "Void";
    }

    public String toShortString(){
        return "V";
    }    


}