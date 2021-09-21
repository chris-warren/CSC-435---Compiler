package AST;

public class ASTNode{
    public int line;
	public int offset;


    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }
}