package TYPES;
import AST.*;

public class CharType extends Type {
    public CharType(){

    }

    public String str(){
        return "Char";
    }

public String toShortString(){
        return "C";
    }

}