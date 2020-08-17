package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
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
        Path filePath = Paths.get(fileName);
        if (!Files.exists(filePath)) {
            throw new FileNotFoundException("This file does not exist");
        }
        char[] wordChars = new String(Files.readAllBytes(filePath)).toLowerCase().toCharArray();
        Set<Character> uniqueCharacters = new TreeSet<>();
        for (char c : wordChars) {
            if (Character.isAlphabetic(c)) {
                uniqueCharacters.add(c);
            }
        }
        Iterator<Character> iterator = uniqueCharacters.iterator();
        StringBuilder result = new StringBuilder();
        int counter = 0;
        while (iterator.hasNext() && counter < 5) {
            result.append(iterator.next());
            counter++;
        }
        return result.toString();
    }
}
