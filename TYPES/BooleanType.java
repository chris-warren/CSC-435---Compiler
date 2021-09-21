package TYPES;
import AST.*;

public class BooleanType extends Type {
    public BooleanType(){

    }

    //public void accept(Visitor v){
    //    v.visit(this);
    //}

    public String str(){
        return "Boolean";
    }

    public String toShortString(){
        return "Z";
    }

}