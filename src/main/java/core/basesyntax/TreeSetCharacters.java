package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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
    public String getUniqueCharacters(String fileName) throws FileNotFoundException {
        StringBuilder data = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String s : lines) {
                data.append(s);
            }
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
        char[] chars = data.toString().toLowerCase().replaceAll("[^a-z]","").toCharArray();
        Set<Character> characterSet = new TreeSet<>();
        for (char ch : chars) {
            characterSet.add(ch);
        }
        StringBuilder builder = new StringBuilder();
        for (char ch : characterSet) {
            builder.append(ch);
        }

        return builder.length() < 5 ? builder.toString() : builder.toString().substring(0, 5);
    }
}
