package core.basesyntax;

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
    private static final int MAX_LENGTH = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        Set<Character> set = new TreeSet<>();
        try (FileReader reader = new FileReader(fileName)) {
            while (reader.ready()) {
                char c = (char) reader.read();
                if (Character.isAlphabetic(c)) {
                    set.add(Character.toLowerCase(c));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator iterator = set.iterator();
        for (int i = 0; i < MAX_LENGTH && iterator.hasNext(); i++) {
            sb.append(iterator.next());
        }
        return sb.toString();
    }
}
