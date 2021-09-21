package AST;

public class Id extends Expr{
    public int line;
	public int offset;

    public String id;



    public Id(){
        line = -1;
        offset = -1;

        id = "test";
    }

    public Id(String i){
        line = -1;
        offset = -1;

        this.id = i;
    }

    public Id(String i, int l, int o){
        line = l;
        offset = o;

        this.id = i;
    }


    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }

}