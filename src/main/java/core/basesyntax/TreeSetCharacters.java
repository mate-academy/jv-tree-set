package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        if (Files.exists(Paths.get(fileName))) {
            Set<Character> charSet = new TreeSet<>();
            char [] charArray = Files.readString(Paths.get(fileName))
                    .replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray();
            for (char i : charArray) {
                charSet.add(i);
            }
            StringBuilder res = new StringBuilder();
            for (char i : charSet) {
                res.append(i);
                if (res.length() >= 5) {
                    break;
                }
            }
            return res.toString().trim();
        } else {
            throw new IOException("File doesn't exist.");
        }

    }
}
