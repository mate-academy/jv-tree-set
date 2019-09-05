package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**	/**
 * <p>Реалізуйте метод `getUniqueCharacters(String fileName)` який приймає як параметр назву файлу.	 * <p>Реалізуйте метод `getUniqueCharacters(String fileName)` який приймає як параметр назву файлу.
 * Для цього використовуйте TreeSet. Файл містить букви латинського алфавіту і розділові знаки.</p>	 * Для цього використовуйте TreeSet. Файл містить букви латинського алфавіту і розділові знаки.</p>
 @@ -17,7 +24,28 @@
  * Результат 2: acf</p>	 * Результат 2: acf</p>
 */

public class TreeSetCharacters {
    private static final int LENGTH_FIFTH = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        String stringChars;
        String result = "";
        Set<Character> set = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int countOfSmbl = reader.read();
            do {
                set.add((char) countOfSmbl);
                countOfSmbl = reader.read();
            } while (countOfSmbl != -1);
            stringChars = set.toString().replaceAll("[^a-zA-Z]", "").toLowerCase();
            for (int i = 0; i < stringChars.length(); i++) {
                if (!result.contains(stringChars.substring(i, i + 1))) {
                    result += stringChars.substring(i, i + 1);
                }
            }
        }
        char[] chars = result.toCharArray();
        Arrays.sort(chars);
        return chars.length > LENGTH_FIFTH ? String.valueOf(chars)
                .substring(0, LENGTH_FIFTH) : String.valueOf(chars);
    }
}
