package AST;

public class FunctionDecl{
    public int line;
	public int offset;

    public TypeNode type;
    public Id id;
    public FormalParameterList params;

    public String tester;


    public FunctionDecl(){
        line = -1;
        offset = -1;
        type = new TypeNode();
        id = new Id();
        params = new FormalParameterList();
    }

    public FunctionDecl(TypeNode t, Id i, FormalParameterList p, String s){
        line = -1;
        offset = -1;
        type = t;
        id = i;
        params = p;
        tester = s;
    }

    public FunctionDecl(TypeNode t, Id i, FormalParameterList p, String s, int l, int o){
        line = l;
        offset = o;
        type = t;
        id = i;
        params = p;
        tester = s;
    }

 

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}