package ir;

public class IRConditionalGoTo extends Instruction{

    public Temp cond;
    public Label label;

    public IRConditionalGoTo(Temp t, Label l){
        cond = t;
        label = l;

    }

    public String toString(){
        String s = "IF "+cond.toString() + " GOTO "+"L"+label.name+";";
        return s;
        
    }

    public void accept(JGenerator v){
        v.visit(this);
    }


}