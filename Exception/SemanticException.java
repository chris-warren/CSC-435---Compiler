package Exception;

public class SemanticException extends RuntimeException {
    public int line;
    public int offset;
    public String message;


    public SemanticException(String m, int l, int o) {
        super(m+":"+String.valueOf(l)+":"+String.valueOf(o));
        message = m;
        line = l;
        offset = o;
        
    }
    public SemanticException(String m) {
        super(m);
        message = m;
        line = -1;
        offset = -1;
        
    }
}