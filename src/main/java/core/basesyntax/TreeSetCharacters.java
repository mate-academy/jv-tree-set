package core.basesyntax;

import java.io.BufferedReader;
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
    public String getUniqueCharacters(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line.toLowerCase());
            }
        }
        Set<Character> set = new TreeSet<>();
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (Character.isLetter(stringBuilder.charAt(i))) {
                set.add(stringBuilder.charAt(i));
            }
        }
        Iterator<Character> iterator = set.iterator();
        String result = "";
        while (iterator.hasNext()) {
            result += iterator.next();
        }
        return result.length() < 6 ? result : result.substring(0, 5);
    }
}
