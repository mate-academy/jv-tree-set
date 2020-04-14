package core.basesyntax;

import java.io.FileNotFoundException;
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
        if (!Files.exists(Paths.get(fileName))) {
            throw new FileNotFoundException();
        }
        StringBuilder sb = new StringBuilder(Files.readString(Paths.get(fileName)).toLowerCase());
        Set<Character> charSet = new TreeSet<>();
        for (int i = 0; i < sb.length(); i++) {
            if (Character.isAlphabetic(sb.charAt(i))) {
                charSet.add(sb.charAt(i));
            }
        }
        sb.setLength(0);
        for (Character c : charSet) {
            sb.append(c);
            if (sb.length() == 5) {
                break;
            }
        }
        return sb.toString();
    }
}
