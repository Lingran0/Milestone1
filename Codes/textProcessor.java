import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class textProcessor {

    // Attribute
    private Set<String> stopWords;

    // Constructor
    public textProcessor(String stopWordsFilePath) throws FileNotFoundException {
        stopWords = new HashSet<>();
        loadStopWords(stopWordsFilePath);
    }

    // Method to load stop words from a file
    private void loadStopWords(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim().toLowerCase();
            stopWords.add(line);
        }
        scanner.close();
    }

    // Method to read a file and return its content as a string
    public String readFile(String filePath) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            content.append(scanner.nextLine()).append(" ");
        }
        scanner.close();
        return content.toString();
    }

    // Method to remove stop words from content
    public String removeStopWords(String content) {
        String[] words = content.split("\\s+");
        StringBuilder filteredContent = new StringBuilder();
        for (String word : words) {
            String cleanWord = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
            if (!stopWords.contains(cleanWord)) {
                filteredContent.append(word).append(" ");
            }
        }
        return filteredContent.toString();
    }
}
