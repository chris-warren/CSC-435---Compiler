package ir;
import TYPES.*;
import java.util.ArrayList;


public class IRFunction extends Instruction{

    public String name;
    public Type returnType;
    public ArrayList<Type> pList;
    public ArrayList<Instruction> iList;
    public TempFactory tempFactory;

    public IRFunction(String n, Type r, ArrayList<Type> l){
        name = n;
        returnType = r;
        pList = l;
        tempFactory = new TempFactory();
    }

    public String toString(){
        String s = "FUNC "+name+" (";

        for(int i = 0; i < pList.size(); i++){
            //System.out.println(pList.get(i));
            if(pList.get(i) instanceof ArrayType){
                s = s+"A"+pList.get(i).toShortString();
            }else{
                s = s+pList.get(i).toShortString();
            }
            
        }

        s = s+")" +returnType.toShortString()+ "\n{";

        //add temp declarations
        ArrayList<Temp> tList = new ArrayList<Temp>();
        tList = tempFactory.tList;

        for(int i = 0; i < tList.size(); i++){
            //file = file +"\n"+ iList.get(i).toString();
            if(tList.get(i).type instanceof ArrayType){
                s = s + "\n\tTEMP "+tList.get(i).name+":A"+tList.get(i).type.toShortString()+";";
            }else{
                s = s + "\n\tTEMP "+tList.get(i).name+":"+tList.get(i).type.toShortString()+";";
            }
            
        }
        //s = s + "\n";

        for(int i = 0; i < iList.size(); i++){
            //file = file +"\n"+ iList.get(i).toString();

            if(iList.get(i) instanceof Label){
                s = s + "\n"+iList.get(i).toString();
            }else{
                s = s + "\n\t\t"+iList.get(i).toString();
            }
    
        }
        s = s + "\n}";
        return s;
    }

    public void accept(JGenerator v){
        v.visit(this);
    }
}