package core.basesyntax;

import java.io.BufferedReader;
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

    private static final int MAX_SIZE = 5;

    public String getUniqueCharacters(String fileName) throws FileNotFoundException {
        Set<Character> chars = new TreeSet<>();

        try (FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            int character = bufferedReader.read();
            while (character != -1) {
                if (Character.isLetter(character)) {
                    chars.add((char) Character.toLowerCase(character));
                }
                character = bufferedReader.read();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new FileNotFoundException("File " + fileName + " is not found");
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Math.min(MAX_SIZE, chars.size()); i++) {
            result.append(chars.toArray()[i]);
        }

        return result.toString();
    }
}
