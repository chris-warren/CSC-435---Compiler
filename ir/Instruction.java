package ir;
import TYPES.*;

public class Instruction{
    public Instruction(){
        
    }
    public void accept(JGenerator v){
        v.visit(this);
    }
}