package com.company;

public class Application {

    public static void main(String[] args) {
	    String outputFile, dataFile;
	    DuplicateCounter myCounter = new DuplicateCounter();

		dataFile = "problem2.txt";
		outputFile = "unique_word_counts.txt";

		System.out.println("Performing count() operation...");
	    myCounter.count(dataFile);

	    System.out.println();

	    System.out.println("Performing write() operation...");
	    myCounter.write(outputFile);

    }
}
