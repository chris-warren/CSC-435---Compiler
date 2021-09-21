package ir;
import TYPES.*;

public class IRPrint extends Instruction{

    public Temp temp;
    public Type type;

    public IRPrint(Temp tmp, Type ty){
        temp = tmp;
        type = ty;
    }

    public String toString(){
        return "PRINT"+type.toShortString()+" "+temp.toString()+";";
    }

    public void accept(JGenerator v){
        v.visit(this);
    }

}