package ir;

public class IROperand{

    public void accept(JGenerator v){
        v.visit(this);
    }

}