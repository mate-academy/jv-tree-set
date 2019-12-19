package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        StringBuilder line = new StringBuilder();
        String words = Files.readString(Paths.get(fileName)).toLowerCase();
        TreeSet<Character> letters = new TreeSet<>();

        for (int i = 0; i < words.length(); i++) {
            if (Character.isLetter(words.charAt(i))) {
                letters.add(words.charAt(i));
            }
        }
        int i = 0;
        for (Character letter : letters) {
            line.append(letter);
            if (++i == 5) {
                break;
            }
        }
        return line.toString();
    }
}
