package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
        Set<String> treeSet = new TreeSet<>();
        String line = "";
        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            while ((line = input.readLine()) != null) {
                treeSet.addAll(Arrays.asList(
                        line.replaceAll("[^a-zA-Z]", "").toLowerCase().split("")));
            }
        } catch (IOException e) {
            throw new FileNotFoundException("File is not found " + e);
        }
        return treeSet.stream()
                .distinct()
                .limit(5)
                .sorted()
                .collect(Collectors.joining());
    }
}
