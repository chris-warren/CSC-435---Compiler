package ir;
import TYPES.*;

public class IRBoolNeg extends IRUnaryOp{

    public Temp op;
    public Type type;

    public IRBoolNeg(Temp o, Type t){
        op = o;
        type = t;
    }

    public String toString(){
        return type.toShortString()+"! " + op.toString();
    }

    public void accept(JGenerator v){
        v.visit(this);
    }

}