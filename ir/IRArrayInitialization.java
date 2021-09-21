package ir;
import TYPES.*;

public class IRArrayInitialization extends IROperand{

    public ArrayType type;

    public IRArrayInitialization(ArrayType t){
        type = t;
    }

    public String toString(){
        int size =type.size;
        return "NEWARRAY "+type.t.toShortString()+" "+ Integer.toString(size);
    }

    public void accept(JGenerator v){
        v.visit(this);
    }

}