package ir;
import java.util.ArrayList;
import java.io.*;

public class IRGen{

    //public list<> lines
    public IRGen(){

    }


    //adds a line to the list
    public void addLine(){

    }

    //outputs lines as an .ir file
    public void printOut(ArrayList<IRFunction> l, String fName){
        String file = "PROG "+fName;
        for(int i = 0; i < l.size(); i++){
            file = file +"\n"+ l.get(i).toString();
            //System.out.println(l.get(i).toString());

        }

        //System.out.println(file);

        try{
            //System.out.println(fName);
            FileWriter fileWriter = new FileWriter("IR_test_files/"+fName+".ir", false);
            fileWriter.write(file);
            fileWriter.close();
        }catch(Exception e){
            System.out.println(e);
        }
        

    }

}