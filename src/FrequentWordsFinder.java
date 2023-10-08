import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequentWordsFinder {

    /**
     * Found unique words from file and count of these words mentions
     *
     * @param sourceFileName    path to text file
     * @return                  a string with unique words from file
     * @throws IOException      if an I/O error occurs reading from the stream
     */
    public String frequentWords(String sourceFileName) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(sourceFileName)));
        Stream<String> stream = Stream.of(content.toLowerCase().split("\\W+")).parallel();
        Map<String, Long> wordCountMap = stream.collect(Collectors.groupingBy(String::toString, Collectors.counting()));

        return convertMapToString(wordCountMap);
    }

    /**
     * Convert Map to String.
     *
     * @param map   contains unique words and number of words mentions
     * @return      a string consisting of a Key and a Value, with each pair starting on a new line
     */
    public String convertMapToString(Map<String, Long> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(e -> e.getKey() + " = " + e.getValue())
                .collect(Collectors.joining("\n"));
    }
}
