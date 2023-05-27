import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string <b>content</b>, find the frequency of each word.
 *
 * For the following challenge, we will solve it the following way:
 *
 * 1. Build a frequency table for each word using Map
 * 2. Put the logic in a separate method to be called individually (in case we will search many times against the same content)
 * 3. Pass the built frequencyTable each time the method <b>findFrequency(..)</b> is called along with the search keyword for a runtime of O(1).
 */
public class Main {
  /**
   * Scan the content and build a frequency table.
   *
   * Time Complexity: O(n), as this is the best conceivable runtime (BSR).
   * Space Complexity: O(n)
   */
  public static Map<String, Integer> buildFrequencyTable(String content) {
    if (content == null || content.isBlank()) {
      return Collections.emptyMap();
    }

    Map<String, Integer> wordsFrequency = new HashMap<>();

    for (String word : content.trim().split(" ")) {
      if (word.isBlank()) {
        continue;
      }

      word = word.trim().toLowerCase();

      wordsFrequency.put(word, wordsFrequency.getOrDefault(word, 0) + 1);
    }

    return wordsFrequency;
  }

  /**
   * Reuse the <b>frequencyTable</b> for searches against the same content multiple times to achieve
   *
   * Time Complexity: O(1)
   * Space Complexity: O(1)
   */
  public static int findFrequency(Map<String, Integer> frequencyTable, String keyword) {
    if (frequencyTable == null || frequencyTable.isEmpty()) {
      return 0;
    }

    return frequencyTable.getOrDefault(keyword.trim().toLowerCase(), 0);
  }
}
