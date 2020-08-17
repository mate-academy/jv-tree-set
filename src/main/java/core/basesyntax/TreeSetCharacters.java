package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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
    public String getUniqueCharacters(String fileName) throws FileNotFoundException {
        Set<String> fileNameTree = new TreeSet<>();
        StringBuilder retval = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String readedLine;
            while ((readedLine = br.readLine()) != null) {
                String[] toArr = readedLine.toLowerCase().replaceAll("[^a-z]", "").split("");
                fileNameTree.addAll(Arrays.asList(toArr));
            }
        } catch (IOException e) {
            throw new FileNotFoundException("No such file ¯|_(ツ)_|¯");
        }
        for (String s : fileNameTree) {
            retval.append(s);
        }
        return (retval.length() <= 5) ? retval.toString() : retval.substring(0, 5);
    }
}

