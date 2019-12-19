package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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
        try {
            List<String> listOfWords = Files.readAllLines(Paths.get(fileName));
            Set<String> listOfUniqueLetters = new TreeSet<>();
            for (char value : listOfWords
                    .toString()
                    .toLowerCase()
                    .toCharArray()) {
                listOfUniqueLetters.add(value + "");
            }
            String result = listOfUniqueLetters.toString().replaceAll(REGEX_NON_WORDS, "");
            return result.substring(0, Math.min(result.length(), 5));
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }
}
