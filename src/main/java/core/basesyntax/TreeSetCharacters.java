package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
        StringBuilder result = new StringBuilder();
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        char[] characters = Files
                .readString(Path.of(fileName))
                .toLowerCase()
                .replaceAll("[^a-z]", "")
                .toCharArray();
        Set<Character> charSet = new TreeSet<>();
        for (char character : characters) {
            charSet.add(character);
        }
        for (char ch : charSet) {
            result.append(ch);
            if (result.length() == 5) {
                break;
            }
        }
        return result.toString();
    }
}
