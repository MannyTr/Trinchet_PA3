public class Application {

    public static void main(String[] args) {
        DuplicateRemover myRemover = new DuplicateRemover();
        String filename, outputFile;

        filename = "problem1.txt";
        outputFile = "unique_words.txt";

        System.out.println("Performing remove() operation...");
        myRemover.remove(filename);

        System.out.println();

        System.out.println("Performing write() operation...");
        myRemover.write(outputFile);

    }
}
