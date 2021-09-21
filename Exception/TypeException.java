package Exception;

public class TypeException extends RuntimeException {
    public int line;
    public int offset;
    public String message;


    public TypeException(String m, int l, int o) {
        super(m+":"+String.valueOf(l)+":"+String.valueOf(o));
        message = m;
        line = l;
        offset = o;
        
    }
    public TypeException(String m) {
        super(m);
        message = m;
        line = -1;
        offset = -1;
        
    }
}