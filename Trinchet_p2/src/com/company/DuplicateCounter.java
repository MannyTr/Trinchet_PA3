package com.company;
import java.io.*;
import java.util.*;


public class DuplicateCounter {
    private ArrayList<Integer> wordCounter= new ArrayList();
    private ArrayList<String> wordList = new ArrayList();

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

    public void count(String dataFile){
        HashMap<String, Integer> countMap= new HashMap();
        FileInputStream inputStream = null;
        Scanner filescnr = null;
        String currWord;

        System.out.println("Opening file \"" + dataFile + "\"...");

        try {
            inputStream = new FileInputStream(dataFile);
            filescnr = new Scanner(inputStream);

            while (filescnr.hasNext()) {
                currWord = filescnr.next();

                if (!countMap.containsKey(currWord)) {
                    countMap.put(currWord, 1);
                } else {
                    int currKey = countMap.get(currWord);
                    countMap.put(currWord, ++currKey);
                }
            }

            for (Map.Entry mapElement : countMap.entrySet()) {
                String key = (String) mapElement.getKey();
                wordList.add(key);

                Integer value = ((Integer) mapElement.getValue());
                wordCounter.add(value);
            }

        } catch (Exception excpt){
            System.out.println("Error found: " + excpt.getMessage());
            System.out.println("Exiting...");
        }
        finally {
            System.out.println("Closing...");
            close(inputStream);
            filescnr.close();
        }
    }

    public void write(String outputFile){
        FileOutputStream outputStream = null;
        PrintWriter outFS = null;

        System.out.println("Opening file \"" + outputFile + "\"...");

        try {
            outputStream = new FileOutputStream(outputFile);
            outFS = new PrintWriter("unique_word_counts.txt");


            for (int i = 0; i < wordList.size(); i++) {
                outFS.println(wordList.get(i) + "-" + wordCounter.get(i));
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
