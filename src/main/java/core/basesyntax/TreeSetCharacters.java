package core.basesyntax;

import java.io.BufferedReader;
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
    private static final int LETTERS_AMOUNT = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        TreeSet<Character> lettersFromFile = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int input = reader.read();
            while (input != -1) {
                if (input >= 'A' && input <= 'Z') {
                    input += 32;
                }
                if (input >= 'a' && input <= 'z') {
                    lettersFromFile.add((char) input);
                }
                input = reader.read();
            }
        }
        StringBuilder result = new StringBuilder();
        int border = LETTERS_AMOUNT;
        for (char letter : lettersFromFile) {
            result.append(letter);
            if (border == 1) {
                break;
            }
            border--;
        }
        return new String(result);
    }
}
