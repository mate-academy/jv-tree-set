package core.basesyntax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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

    public String getUniqueCharacters(String fileName) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        Set<Character> charsFromFile = new TreeSet<>();
        try (InputStream fileInputStream = new FileInputStream(fileName)) {
            while (fileInputStream.available() > 0) {
                char charReadedFromFile = (char) fileInputStream.read();
                if (Character.isLetter(charReadedFromFile)) {
                    charsFromFile.add(Character.toLowerCase(charReadedFromFile));
                }
            }
        } catch (Exception e) {
            throw new FileNotFoundException("File not Found!");
        }
        for (Character character : charsFromFile) {
            if (result.length() < MAX_LENGTH) {
                result.append(character);
            }
        }
        return result.toString();
    }
}
