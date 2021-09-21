package AST;

public class Statement{
    public int line;
	public int offset;

    public Statement(){
        line = -1;
        offset = -1;
    }

    public Statement(int l, int o){
        line = l;
        offset = o;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}