package core.basesyntax;

import java.io.BufferedReader;
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
    private static final int RESULT_LENGTH = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        Set<String> treeSet = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int value;
            while ((value = reader.read()) != -1) {
                if (Character.isLetter(value)) {
                    treeSet.add(Character.toString(value).toLowerCase());
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        StringBuilder string = new StringBuilder();
        for (String value : treeSet) {
            if (string.length() < RESULT_LENGTH) {
                string.append(value);
            }
        }
        return string.toString();
    }
}
