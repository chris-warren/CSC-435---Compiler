package AST;

public class CharacterLiteral extends Expr{
    public int line;
	public int offset;

    public char val;

    public CharacterLiteral(){
        line = -1;
        offset = -1;
    }

    public CharacterLiteral(char c){
        line = -1;
        offset = -1;

        val = c;
    }

    public CharacterLiteral(char c, int l, int o){
        line = l;
        offset = o;

        val = c;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}