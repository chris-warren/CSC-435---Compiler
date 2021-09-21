package ir;
import TYPES.*;


public class Temp extends IROperand{
    public Type type;
    public String name;
    public String tempType;

    public Temp(Type t, String n, String tt){
        type = t;
        name = n;
        tempType = tt;
    }

    public String toString(){
        String s = "";
        if(tempType == "TEMP" || tempType == "LOCAL"){
            s = "T"+name;
        }else if(tempType == "PARAMETER"){
            s = "T"+name;
        }
        return s;
    }

    public void accept(JGenerator v){
        v.visit(this);
    }
}