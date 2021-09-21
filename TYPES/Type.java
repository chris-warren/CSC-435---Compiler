package TYPES;
import AST.*;

public class Type{
    public Type(){

    }
    

    public String str(){
        return "idk";
    }

    public String toShortString(){
        return "idk";
    }

    public Boolean equals(Type t){
            if(t.str().equals(str())){
                return true;
            }
            else{
                return false;
            }
    }
}