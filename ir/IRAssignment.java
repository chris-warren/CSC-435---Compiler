package ir;

public class IRAssignment extends Instruction{

    public Temp temp;
    public IROperand op;

    public IRAssignment(Temp t, IROperand o){
        temp = t;
        op = o;
    }

    public String toString(){
        return temp.toString() + " := "+op.toString()+";";
    }

    public void accept(JGenerator v){
        v.visit(this);
    }
}