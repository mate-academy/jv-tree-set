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
    public String getUniqueCharacters(String fileName) throws IOException {
        StringBuilder result = new StringBuilder();
        TreeSet<Character> treeSetOfCharsFromFile = new TreeSet<>();
        try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {
            String lineFromFile;
            outer:
            while ((lineFromFile = file.readLine()) != null) {
                lineFromFile = lineFromFile.toLowerCase();
                char[] arrayFileLetters = lineFromFile.toCharArray();
                for (int i = 0; i < arrayFileLetters.length; i++) {
                    if (Character.isLetter(arrayFileLetters[i])) {
                        treeSetOfCharsFromFile.add(arrayFileLetters[i]);
                    }
                }

            }
        }
        for (Character item : treeSetOfCharsFromFile) {
            if (result.length() != 5) {
                result.append(item);
            }
        }
        return result.toString();
    }
}

