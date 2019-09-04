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
    private static final int NUMBER_OF_CHARS = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        TreeSet<Character> charSet = new TreeSet<>();
        String finalChars = "";

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                String charsOnly = fileReader.readLine().toLowerCase().replaceAll("[^a-zA-Z]", "");
                for (int i = 0; i < charsOnly.length(); i++) {
                    charSet.add(charsOnly.charAt(i));
                }
            }

            int size = charSet.size();
            for (int i = 0; i < size; i++) {
                char firstChar = charSet.first();
                if (i < NUMBER_OF_CHARS) {
                    finalChars += firstChar;
                    charSet.remove(firstChar);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return finalChars;
    }
}
