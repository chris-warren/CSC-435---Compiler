package ir;
import TYPES.*;

public class IRArrayReference extends Temp{

    public Temp id;
    public Temp index;
    public Type type;
    public String tc;
    public String name;

    public IRArrayReference(Type t, String n, String tt, Temp t1, Temp t2){
        super(t, n, tt);
        type = t;
        name = n;
        tc = tt;
        id = t1;
        index = t2;
        
    }

    public String toString(){
        return id.toString()+"["+index.toString()+"]";
        //return "test";
    }

    public void accept(JGenerator v){
        v.visit(this);
    }
}