package AST;

public class IntLiteral extends Expr{
    public int line;
	public int offset;

    public int val;

    public IntLiteral(){
        line = -1;
        offset = -1;
        System.out.println("wrong intliteral constructor");
    }

    public IntLiteral(int v){
        line = -1;
        offset = -1;
        val = v;
        
    }

    public IntLiteral(int v, int l, int o){
        line = l;
        offset = o;
        val = v;
        
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}