package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    private static final int SIZE_OF_OUTPUT_STRING = 5;

    public String getUniqueCharacters(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        try (FileReader reader = new FileReader(file)) {
            Set<Character> set = new TreeSet<>();
            int readValue;
            while ((readValue = reader.read()) != -1) {
                if (Character.isLetter(readValue)) {
                    set.add((char) Character.toLowerCase(readValue));
                }
            }
            StringBuilder builder = new StringBuilder();
            Iterator<Character> iterator = set.iterator();
            for (int i = 0; i < SIZE_OF_OUTPUT_STRING; i++) {
                if (iterator.hasNext()) {
                    builder.append(iterator.next());
                }
            }
            return builder.toString();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return "";
    }
}