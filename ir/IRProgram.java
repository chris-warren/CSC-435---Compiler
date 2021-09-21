package ir;

import java.util.ArrayList;

public class IRProgram{

    public ArrayList<Instruction> iList;

    public IRProgram(){
        iList = new ArrayList<Instruction>();
    }

    public void accept(JGenerator v){
        v.visit(this);
    }

}