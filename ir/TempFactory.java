package ir;
import java.util.ArrayList;
import TYPES.*;
import java.io.*;

public class TempFactory{

    public ArrayList<Temp> tList;
    public ArrayList<Temp> pList;
    public ArrayList<Label> lList;

    public TempFactory() {
        tList = new ArrayList<Temp>();
        lList = new ArrayList<Label>();
        pList = new ArrayList<Temp>();
    }

    public Temp createTemp(Type t, String tt ){

            
        if(tt == "PARAMETER"){
            Temp temp = new Temp(t, (Integer.toString(tList.size())), tt);
            tList.add(temp);
            return temp;
        }
        if(tt == "TEMP" || tt == "LOCAL"){
            Temp temp = new Temp(t, (Integer.toString(tList.size())), tt);
            tList.add(temp);
            return temp;
        }
        System.out.println("whoopsy");
        return null;
    }

    public Label createLabel(){
        Label label = new Label(lList.size());
        lList.add(label);
        return label;
    }

    public void output(String fName){
        String file = "";
        for(int i = 0; i < tList.size(); i++){
            file = file + tList.get(i)+"\n";
        }

        try{
            System.out.println(fName);
            FileWriter fileWriter = new FileWriter("IR_test_files/"+fName);
            fileWriter.write(file);
            fileWriter.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

}