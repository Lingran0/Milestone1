import java.util.HashMap;
import java.util.Map;

public class statisticCalculator {

    // Method to count the number of words
    public int calculateWords(String content) {
        String[] words = content.split("\\s+");
        return words.length;
    }

    // Method to count the number of sentences
    public int calculateStatements(String content) {
        String[] sentences = content.split("[.!?]");
        return sentences.length;
    }

    // Method to calculate the frequency of words in the text
    public Map<String, Integer> calculateWordFrequency(String content) {
        String[] words = content.toLowerCase().split("\\s+");
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "");
            if (!word.isEmpty()) {
                if (wordFrequency.containsKey(word)) {
                    wordFrequency.put(word, wordFrequency.get(word) + 1);
                } else {
                    wordFrequency.put(word, 1);
                }
            }
        }
        return wordFrequency;
    }
}
