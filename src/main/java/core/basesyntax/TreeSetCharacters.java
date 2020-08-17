package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
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
    public static final int LETTERS_LIMIT = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        TreeSet<Character> treeSet = new TreeSet<>();
        try (BufferedReader textHolder = new BufferedReader(new FileReader(fileName))) {
            int character;
            while ((character = textHolder.read()) != -1) {
                if (Character.isLetter(character)) {
                    treeSet.add((char) Character.toLowerCase(character));
                }
            }
        } catch (FileNotFoundException message) {
            throw new FileNotFoundException("File not found");
        }
        StringBuilder result = new StringBuilder();
        Iterator<Character> iterator = treeSet.iterator();
        for (int i = 0; i < LETTERS_LIMIT && iterator.hasNext(); i++) {
            result.append(iterator.next());
        }
        return result.toString();
    }
}
