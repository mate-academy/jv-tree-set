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
    private static final int SYMBOL_QUANTITY = 5;

    public String getUniqueCharacters(String file) throws IOException {
        TreeSet<Character> symbols = new TreeSet<>();
        StringBuilder result = new StringBuilder();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            while (fileReader.ready()) {
                result.append(fileReader.readLine());
            }
        }

        char[] line = result.toString().replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray();
        result.setLength(0);
        for (Character i : line) {
            symbols.add(i);
        }

        int i = 0;
        for (Character chars : symbols) {
            result.append(chars);
            if (++i == SYMBOL_QUANTITY) {
                break;
            }
        }
        return result.toString();
    }
}
