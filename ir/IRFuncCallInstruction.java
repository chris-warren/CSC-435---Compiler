package ir;
import java.util.ArrayList;
import TYPES.*;

public class IRFuncCallInstruction extends Instruction{
    public String fName;
    public ArrayList<Temp> arguments;
    public Type rType;

    public IRFuncCallInstruction(String s, ArrayList<Temp> a, Type t){
        fName = s;
        arguments = a;
        rType = t;
    }

    public String toString(){
        String s = "CALL " +fName+"(";
        for(int i = 0; i < arguments.size(); i++){
            s = s + arguments.get(i).toString();
            if(i < arguments.size() - 1){
                s = s + " ";
            }
        }
        s = s + ");";
        return s;
    }

    public void accept(JGenerator v){
        v.visit(this);
    }
}