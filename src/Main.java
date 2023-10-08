import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        // Absolute path to the text file
        String sourceFileName = "";
        // Absolute path of text file for write frequently occurring words
        String destFileName = "";
        FrequentWordsFinder utility = new FrequentWordsFinder();
        Path path = Paths.get(destFileName);

        Files.write(path, utility.frequentWords(sourceFileName).getBytes());

        // show frequently occurring words on the console
        System.out.println(utility.frequentWords(sourceFileName));
    }
}
