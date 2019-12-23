package core.basesyntax;

import java.io.BufferedReader;
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

    public String getUniqueCharacters(String fileName) throws FileNotFoundException {

        TreeSet<Character> set = new TreeSet<>();
        StringBuilder readFromFile = new StringBuilder();
        if (fileName != null) {

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                while (reader.ready()) {
                    readFromFile.append(reader.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String str = readFromFile.toString().toLowerCase();
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (Character.isLetter(array[i])) {
                set.add(array[i]);
            }
        }
        StringBuilder res = new StringBuilder();
        while (set.size() != 0 && res.length() < 5) {
            res.append(set.pollFirst());
        }
        return res.toString();
    }
}
