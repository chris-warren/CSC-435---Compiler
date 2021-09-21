package ir;
import TYPES.*;

public class IRConst<V> extends IROperand{
    public Type type;
    public V val;

    public IRConst(Type t){
        type = t;

    }

    public String toString(){
        if(type instanceof StringType){
            return '"'+val.toString()+'"';
        }else if(type instanceof BooleanType){
            String s = val.toString();
            if(s.equals("true")){
                return "TRUE";
            }else{
                return "FALSE";
            }

        }else if(type instanceof CharType){
            return "'"+val.toString()+"'";
        }else{
            return val.toString();
        }
        
    }

    public void accept(JGenerator v){
        v.visit(this);
    }
}