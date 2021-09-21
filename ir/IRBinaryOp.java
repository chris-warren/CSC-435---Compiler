package ir;

public class IRBinaryOp extends IROperand{

    

    public IRBinaryOp(){

    }

    public void accept(JGenerator v){
        v.visit(this);
    }
}