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

    public static String getUniqueCharacters(String fileName) throws IOException {
        char[] charArray = Files.readString(Paths.get(fileName))
                .replaceAll("[^a-zA-Z ]", "")
                .toLowerCase().toCharArray();
        Set<Character> characterSet = new TreeSet<>();
        for (char character : charArray) {
            characterSet.add(character);
        }
        StringBuilder result = new StringBuilder();
        for (char letter : characterSet) {
            result.append(letter);
            if (result.length() > 5) {
                break;
            }
        }
        return result.toString().trim();
    }
}

