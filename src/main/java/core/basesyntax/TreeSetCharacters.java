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
    private static final int MAX_LETTERS = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        StringBuilder resultStr = new StringBuilder();
        Set<String> latterSet = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int charValue;
            while ((charValue = reader.read()) != -1) {
                String symbol = String.valueOf((char) charValue).toLowerCase();
                if (symbol.matches("[a-z]")) {
                    latterSet.add(symbol);
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        }

        int count = 0;
        for (String s : latterSet) {
            count++;
            resultStr.append(s);
            if (count == MAX_LETTERS) {
                return resultStr.toString();
            }
        }
        return resultStr.toString();
    }
}
