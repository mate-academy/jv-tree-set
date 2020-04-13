package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
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
        String line = "";
        TreeSet<Character> treeSet = new TreeSet<>();
        try (BufferedReader fin = new BufferedReader(new FileReader(new File(fileName)))) {
            while ((line = fin.readLine()) != null) {
                line = line.replaceAll("[0-9]*\\W*", "");
                line = line.toLowerCase();
                char[] chars = line.toCharArray();
                for (int i = 0; i < line.length(); i++) {
                    treeSet.add(chars[i]);
                    System.out.println(treeSet);
                }
            }
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Character> itr = treeSet.iterator();
        while (itr.hasNext()) {
            stringBuilder.append(itr.next());
        }
        if (stringBuilder.length() == 0) {
            return "";
        }
        if (stringBuilder.length() < 5) {
            return stringBuilder.toString();
        }
        return stringBuilder.delete(5, stringBuilder.length()).toString();
    }
}

