package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
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
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String clearedData = lines.toString().toLowerCase().replaceAll("[^a-zA-Z]+", "");
        SortedSet<Character> uniqueCharacters = new TreeSet();
        for (int i = 0; i < clearedData.length(); i++) {
            uniqueCharacters.add(clearedData.charAt(i));
        }
        StringBuilder returnedData = new StringBuilder();
        Iterator iterator = uniqueCharacters.iterator();

        while (iterator.hasNext()) {
            returnedData.append(iterator.next().toString());
            if (returnedData.length() == 5) {
                return returnedData.toString();
            }
        }
        return returnedData.toString();
    }
}
