import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

public class DuplicateRemover {
    private ArrayList<String> uniqueWords= new ArrayList<>();

    public static void close(FileInputStream fileName){
        try {
            if (fileName != null) {
                fileName.close();
            }
        } catch (IOException closeExcpt){
            System.out.println("Error found: " + closeExcpt.getMessage());
        }
    }

    public static void close(FileOutputStream fileName){
        try {
            if (fileName != null) {
                fileName.close();
            }
        } catch (IOException closeExcpt){
            System.out.println("Error found: " + closeExcpt.getMessage());
        }
    }

    public static void close(StringWriter fileName){
        try {
            if (fileName != null) {
                fileName.close();
            }
        } catch (IOException closeExcpt){
            System.out.println("Error found: " + closeExcpt.getMessage());
        }
    }

   public void remove (String dataFile){
        FileInputStream inputStream = null;
        Scanner filescnr = null;
        HashSet<String> mySet= new HashSet<>();
        StringWriter stringStream = new StringWriter();
        PrintWriter printWrite = new PrintWriter(stringStream);
        String currWord;

        System.out.println("Opening file \"" + dataFile + "\"...");
        try {
            inputStream = new FileInputStream(dataFile);
            filescnr = new Scanner(inputStream);

            while (filescnr.hasNext()) {
                currWord = filescnr.next();

                if (!mySet.contains(currWord)) {
                    mySet.add(currWord);
                    uniqueWords.add(currWord);
                    printWrite.print(currWord + " ");
                }
            }

        } catch (Exception excpt){
            System.out.println("Error found: " + excpt.getMessage());
            System.out.println("Exiting...");
        }
        finally {
            close(inputStream);
            close(stringStream);
            printWrite.close();
        }

        modifyFile(dataFile, stringStream);

   }

   public void modifyFile(String dataFile, StringWriter stringStream) {
       FileOutputStream outputStream = null;
       PrintWriter outFS = null;

       try {
           outputStream = new FileOutputStream(dataFile);
           outFS = new PrintWriter(outputStream);

           outFS.print(stringStream.toString());
           outFS.flush();
       } catch (Exception excpt){
           System.out.println("Error found: " + excpt.getMessage());
           System.out.println("Exiting...");
       }
       finally{
           System.out.println("Closing...");
           close(outputStream);
           outFS.close();
       }


   }

   public void write (String outputFile){
        FileOutputStream outputStream = null;
        PrintWriter outFS = null;

       System.out.println("Opening file \"" + outputFile + "\"...");
       try {
           outputStream = new FileOutputStream(outputFile);
           outFS = new PrintWriter("unique_words.txt");

           for (int i = 0; i < uniqueWords.size(); i++) {
               outFS.println(uniqueWords.get(i));
           }

           outFS.flush();
       } catch (Exception excpt){
           System.out.println("Error found: " + excpt.getMessage());
           System.out.println("Exiting...");
       }
       finally {
           System.out.println("Closing...");
           outFS.close();
           close(outputStream);
       }

   }


}
