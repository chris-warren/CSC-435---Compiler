package AST;

public class Function{
    public int line;
	public int offset;

    public FunctionDecl declaration;
    public FunctionBody body;
    public String name;

    public Function(FunctionDecl d, FunctionBody b, String n){
        line = -1;
        offset = -1;
        declaration = d;
        body = b;
        name = n;
    }

    public Function(FunctionDecl d, FunctionBody b, String n, int l, int o){
        line = l;
        offset = o;
        declaration = d;
        body = b;
        name = n;
    }

    public Function(){
        line = -1;
        offset = -1;
        declaration = new FunctionDecl();
        body = new FunctionBody();
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}