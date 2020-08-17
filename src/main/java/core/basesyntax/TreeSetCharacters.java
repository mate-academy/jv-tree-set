package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public static String getUniqueCharacters(String fileName) throws FileNotFoundException {
        String fileText;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            fileText = bufferedReader.lines()
                   .map(x -> x.replaceAll("\\W*\\d*", ""))
                    .collect(Collectors.joining())
                   .toLowerCase();
        } catch (IOException e) {
            throw new FileNotFoundException("This file has not found");
        }
        TreeSet<String> treeSet = Stream.of(fileText.split(""))
                .sorted()
                .collect(Collectors.toCollection(TreeSet::new));
        return treeSet.size() >= 5 ? String.join("", treeSet).substring(0, 5)
                : String.join("", treeSet);
    }

}
