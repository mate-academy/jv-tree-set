package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    public static final int LENGTH_FIFTH = 5;

    public String getUniqueCharacters(String fileName) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        TreeSet<Character> uniqueCharacters = new TreeSet<>();
        int count = 0;
        int size = 0;
        try (FileReader fileReader = new FileReader(fileName)) {
            while (fileReader.ready()) {
                char ch = (char) fileReader.read();
                if (Character.isLetter(ch)) {
                    uniqueCharacters.add(Character.toLowerCase(ch));
                }
            }
        } catch (IOException e) {
            throw new FileNotFoundException();
        }

        for (char c : uniqueCharacters) {
            if (count == 5) {
                break;
            }
            result.append(c);
            count++;
        }

        return result.toString();
    }
}

