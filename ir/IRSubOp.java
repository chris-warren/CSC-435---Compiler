package ir;
import TYPES.*;

public class IRSubOp extends IRBinaryOp{
    Type type;
    Temp temp1;
    Temp temp2;

    public IRSubOp(Type t, Temp t1, Temp t2){
        type = t;
        temp1 = t1;
        temp2 = t2;
    }

    public String toString(){
        return temp1.toString() +" " +type.toShortString()+ "- "+temp2.toString(); 
    }

    public void accept(JGenerator v){
        v.visit(this);
    }
}