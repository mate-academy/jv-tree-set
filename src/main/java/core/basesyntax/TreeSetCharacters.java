package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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
        TreeSet<Character> treeSet = new TreeSet<>();
        try (Reader reader = new FileReader(fileName)) {
            int character = reader.read();
            while (character != -1) {
                if (Character.isLetter(character)) {
                    treeSet.add((char) Character.toLowerCase(character));
                }
                character = reader.read();
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found! " + e);
        }
        StringBuilder result = new StringBuilder();
        for (Character element : treeSet) {
            result.append(element);
            if (result.length() == 5) {
                return result.toString();
            }
        }
        return result.toString();
    }
}
