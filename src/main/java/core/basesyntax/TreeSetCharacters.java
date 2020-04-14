package core.basesyntax;

import java.io.FileNotFoundException;
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
    public static final int LENGTH_FIFTH = 5;

    public String getUniqueCharacters(String fileName) throws FileNotFoundException {
        String result;
        Set<String> uniqueCharacters = new TreeSet<>();
        try (FileReader fileReader = new FileReader(fileName)) {
            while (fileReader.ready()) {
                char ch = (char) fileReader.read();
                if (Character.isLetter(ch)) {
                    uniqueCharacters.add(String.valueOf(ch).toLowerCase());
                }
            }
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
        result = String.join("", uniqueCharacters);
        return result.length() > LENGTH_FIFTH
                ? result.substring(0, LENGTH_FIFTH)
                : result;
    }
}

