package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * <p>Реалізуйте метод `getUniqueCharacters(String fileName)` який приймає як параметр назву файлу.
 * Для цього використовуйте TreeSet. Файл містить букви латинського алфавіту і розділові знаки.</p>
 *
 * <p>Метод повинен відсортувати всі букви по алфавіту і повернути строку з 5 різних букв без
 * розділових знаків. Якщо у файлі міститься менше п'яти різних букв, то потрібно повернути їх усі.
 * Можливий випадок, коли переданого файлу не існує, в такому разі потрібно викинути помилку про
 * відсутність файлу.</p>
 *
 * <p>Приклад 1: ur-BvT?^ ra w; p
 * Результат 1: abprt</p>
 *
 * <p>Приклад 2: A _f*c a?F
 * Результат 2: acf</p>
 */
public class TreeSetCharacters {

    private static final int NUMBER_OF_RETURNED_VALUES = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        StringBuilder result = new StringBuilder();
        try (FileReader reader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(reader)) {
            StringBuilder textFromFile = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                textFromFile.append(line);
            }
            String lettersString = textFromFile.toString().toLowerCase()
                    .replaceAll("[^A-Za-z]", "");
            TreeSet<Character> letters = new TreeSet<>();
            for (char letter : lettersString.toCharArray()) {
                letters.add(letter);
            }

            Iterator<Character> iterator = letters.iterator();
            for (int i = 0; i < NUMBER_OF_RETURNED_VALUES; i++) {
                if (iterator.hasNext()) {
                    result.append(iterator.next());
                }
            }
        }
        return result.toString();
    }
}
