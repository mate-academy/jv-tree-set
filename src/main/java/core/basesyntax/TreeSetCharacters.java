package core.basesyntax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            int data;
            while ((data = inputStream.read()) != -1) {
                if (Character.isAlphabetic(data)) {
                    char ch = (char) Character.toLowerCase(data);
                    uniqueChars.add(ch);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (char c : uniqueChars) {
            result.append(c);
            if (++n >= 5) {
                break;
            }
        }
        return result.toString();
    }
}
