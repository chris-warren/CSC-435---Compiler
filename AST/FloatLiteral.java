package AST;

public class FloatLiteral extends Expr{
    public int line;
	public int offset;

    public float val;

    public FloatLiteral(float f){
        line = -1;
        offset = -1;

        val = f;
    }

    public FloatLiteral(float f, int l, int o){
        line = l;
        offset = o;

        val = f;
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}