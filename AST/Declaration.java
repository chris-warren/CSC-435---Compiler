package AST;

public class Declaration{
    public int line;
	public int offset;

    public TypeNode type;
    public Id id;

    public Declaration(TypeNode t, Id i){
        line = -1;
        offset = -1;
        type = t;
        id = i;
    }

    public Declaration(TypeNode t, Id i, int l, int o){
        line = l;
        offset = o;
        type = t;
        id = i;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}