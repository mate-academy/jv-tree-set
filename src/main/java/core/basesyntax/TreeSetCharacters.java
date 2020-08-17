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
    private static final int MAX_COUNT_OF_LETTERS = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        String line;
        StringBuilder concat = new StringBuilder();
        Set<Character> set = new TreeSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                concat.append(line.toLowerCase());
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException();
        }

        for (int i = 0; i < concat.length(); i++) {
            if (Character.isLetter(concat.toString().charAt(i))) {
                set.add(concat.toString().charAt(i));
            }
        }
        if (set.isEmpty()) {
            return "";
        }
        concat.delete(0, concat.length());
        for (Character character : set) {
            concat.append(character);
            if (concat.length() == MAX_COUNT_OF_LETTERS) {
                break;
            }
        }
        return concat.toString();
    }
}
