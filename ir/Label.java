package ir;

public class Label extends Instruction{

    public int name;

    public Label(int i){
        name = i;
    }

    public String toString(){
        return "L"+Integer.toString(name)+":;";
    }

    public void accept(JGenerator v){
        v.visit(this);
    }
}