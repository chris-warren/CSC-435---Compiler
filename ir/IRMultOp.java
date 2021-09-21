package ir;
import TYPES.*;

public class IRMultOp extends IRBinaryOp{
    
    public Type type;
    public Temp temp1;
    public Temp temp2;

    public IRMultOp(Type t, Temp t1, Temp t2){
        type = t;
        temp1 = t1;
        temp2 = t2;
    }

    public String toString(){
        return temp1.toString() +" " +type.toShortString()+ "* "+temp2.toString(); 
    }

    public void accept(JGenerator v){
        v.visit(this);
    }
}