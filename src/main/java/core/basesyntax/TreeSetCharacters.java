package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
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
        char[] chars = Files.readString(Paths.get(fileName)).toLowerCase()
                .replaceAll("[^A-Za-z]", "").toCharArray();
        Set<Character> set = new TreeSet<>();
        for (char value : chars) {
            set.add(value);
        }
        Iterator<Character> iterator = set.iterator();
        StringBuilder stringFromFile = new StringBuilder();
        int i = 0;
        while (iterator.hasNext()) {
            stringFromFile.append(iterator.next());
            i++;
            if (i > 4) {
                break;
            }
        }
        return stringFromFile.toString();
    }
}
