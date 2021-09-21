package ir;

public class IRUnconditionalGoTo extends Instruction{

    public Label label;

    public IRUnconditionalGoTo(Label l){
        label = l;

    }

    public String toString(){
        String s = "GOTO "+"L"+label.name+";";
        return s;
        
    }

    public void accept(JGenerator v){
        v.visit(this);
    }


}