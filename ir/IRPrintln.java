package ir;
import TYPES.*;

public class IRPrintln extends Instruction{

    public Temp temp;
    public Type type;

    public IRPrintln(Temp tmp, Type ty){
        temp = tmp;
        type = ty;
    }

    public String toString(){
        return "PRINTLN"+type.toShortString()+" "+temp.toString()+";";
    }

    public void accept(JGenerator v){
        v.visit(this);
    }

}