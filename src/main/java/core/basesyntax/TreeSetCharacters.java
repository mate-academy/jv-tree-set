package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
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
    private static final String REGEX_NON_WORDS = "[^a-z]";

    public String getUniqueCharacters(String fileName) throws FileNotFoundException {
        String words;
        try {
            words = Files.readString(Paths.get(fileName))
                    .toLowerCase()
                    .replaceAll(REGEX_NON_WORDS, "");
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
        Set<String> listOfUniqueLetters = new TreeSet<>(Arrays.asList(words.split("")));
        StringBuilder ch = new StringBuilder();
        for (String c : listOfUniqueLetters) {
            if (ch.length() < 5) {
                ch.append(c);
            }
        }
        return ch.toString();
    }
}
