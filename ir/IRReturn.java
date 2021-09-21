package ir;

public class IRReturn extends Instruction{

    public Temp temp;

    public IRReturn(Temp t){
        temp = t;
    }

    public IRReturn(){
        temp = null;
    }

    public String toString(){
        if(temp == null){
            return "RETURN;";
        }else{
            return "RETURN "+temp.toString()+";";
        }
    }

    public void accept(JGenerator v){
        v.visit(this);
    }
}