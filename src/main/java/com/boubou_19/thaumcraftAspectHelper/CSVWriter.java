package com.boubou_19.thaumcraftAspectHelper;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class CSVWriter {
    private PrintWriter printer;
    private  FileWriter writer;
    private String path;

    public CSVWriter(String csvPath){
     this.path = csvPath;
     File csv = new File(this.path);
     if (csv.isFile()){
         csv.delete();
     }
     try {
         this.writer = new FileWriter(this.path, true);
         this.printer = new PrintWriter(this.writer);
        }
        catch (Exception e){
         e.printStackTrace();
     }


     }
     public void writeToFile( String textLine ) throws IOException {

         this.printer.printf( "%s" + "%n" , textLine);


     }
     public void close(){
         try {
             this.printer.close();
             this.writer.close();
         } catch (IOException|NullPointerException e) {
             e.printStackTrace();
         }
     }


}
