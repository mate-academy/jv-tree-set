package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    private static final int MAX_NUMBER_OF_CHARS_IN_RESULT = 5;

    public String getUniqueCharacters(String fileName) throws FileNotFoundException {
        Set<Character> characterTreeSet = new TreeSet<>();
        try (FileReader reader = new FileReader(new File(fileName))) {
            for (int ch = reader.read(); ch != -1; ch = reader.read()) {
                if (Character.isAlphabetic(ch)) {
                    characterTreeSet.add(Character.toLowerCase((char) ch));
                }
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StringBuilder sb = new StringBuilder();
        characterTreeSet.stream()
                .limit(MAX_NUMBER_OF_CHARS_IN_RESULT)
                .forEach(sb::append);
        return sb.toString();
    }
}
