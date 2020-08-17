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
    private static final int NAME_LENGTH = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        TreeSet<Character> stringSet = new TreeSet<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            int inputChar = 0;
            while ((inputChar = bufferedReader.read()) != -1) {
                if (Character.isAlphabetic(inputChar)) {
                    stringSet.add((char) Character.toLowerCase(inputChar));
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        int resultSize = Math.min(stringSet.size(), NAME_LENGTH);
        for (int i = 0; i < resultSize; i++) {
            stringBuilder.append(stringSet.pollFirst());
        }
        return stringBuilder.toString();
    }
}
