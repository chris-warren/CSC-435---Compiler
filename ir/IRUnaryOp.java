package ir;

public class IRUnaryOp extends IROperand{
    public void accept(JGenerator v){
        v.visit(this);
    }
}