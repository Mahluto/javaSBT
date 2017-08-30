import java.util.*;

/**
 * Created by robert on 28.08.17.
 */
public class Task2056 {


    public void mostPopularWord(String str) {

        String str1 = str.toLowerCase();
        String strArray[] = str1.split(" ");
        Map<String, Integer> uniqueWords = new HashMap<String, Integer>();

        for (String word: strArray) {
            Integer existingCount = uniqueWords.get(word);
            if (existingCount == null) {
                uniqueWords.put(word, 1);
            }
            else {
                uniqueWords.put(word, existingCount + 1);
            }
        }

        Integer maxValue = Collections.max(uniqueWords.values());
        Set<Map.Entry<String, Integer>> uniqueSet = uniqueWords.entrySet();

        for (Map.Entry<String, Integer> entry : uniqueSet) {

            if (entry.getValue() >= maxValue) {
                System.out.println(entry.getKey());
            }

        }
    }
}
