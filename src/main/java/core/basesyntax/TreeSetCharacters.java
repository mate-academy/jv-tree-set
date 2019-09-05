package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * <p>Реалізуйте метод `getUniqueCharacters(String fileName)` який приймає як параметр назву файлу.
 * Для цього використовуйте TreeSet. Файл містить букви латинського алфавіту і розділові знаки.</p>
 *
 * <p>Метод повинен відсортувати всі букви по алфавіту і повернути строку з 5 різних букв без
 * розділових знаків.
 * Якщо у файлі міститься менше п'яти різних букв, то потрібно повернути їх усі.
 * Можливий випадок, коли переданого файлу не існує, в такому разі потрібно викинути помилку
 * про відсутність файлу.</p>
 *
 * <p>Приклад 1: ur-BvT?^ ra w; p
 * Результат 1: abprt</p>
 *
 * <p>Приклад 2: A _f*c a?F
 * Результат 2: acf</p>
 */
public class TreeSetCharacters {
    public String getUniqueCharacters(String fileName) throws IOException {
        Set<Character> uniqueChars = new TreeSet<>();
        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            String nextString = null;
            while (true) {
                try {
                    if ((nextString = input.readLine()) == null) {
                        break;
                    }
                    String charsString = nextString.toLowerCase().replaceAll("[^a-z]", "");
                    for (int i = 0; i < charsString.length(); i++) {
                        uniqueChars.add(charsString.charAt(i));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            throw e;
        }

        String result = "";
        for (char c : uniqueChars) {
            result += c;
            if (result.length() >= 5) {
                break;
            }
        }
        return result;
    }

}
