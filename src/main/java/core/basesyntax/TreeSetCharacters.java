package core.basesyntax;

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
    public static final int MAX_COUNT = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        TreeSet<Character> letters = new TreeSet<>();

        try (FileReader reader = new FileReader(fileName)) {
            int character = reader.read();
            while (character != -1) {
                if (Character.isLetter(character)) {
                    letters.add((char)Character.toLowerCase(character));
                }
                character = reader.read();
            }
        }

        StringBuilder result = new StringBuilder();
        int count = Math.min(letters.size(), MAX_COUNT);
        for (int i = 0; i < count; i++) {
            result.append(letters.pollFirst());
        }
        return result.toString();
    }
}
