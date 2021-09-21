package AST;

public class StringLiteral extends Expr{
    public int line;
	public int offset;

    public String val;

    public StringLiteral(){
        line = -1;
        offset = -1;
    }

    public StringLiteral(String s){
        line = -1;
        offset = -1;
        val = s;
    }

    public StringLiteral(String s, int l, int o){
        line = l;
        offset = o;
        val = s;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}