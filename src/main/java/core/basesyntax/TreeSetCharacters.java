package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
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
        int count = 5;
        StringBuilder result = new StringBuilder();
        Set<Character> set = new TreeSet<>();
        try {
            String allFile = Files.readString(Paths.get(fileName)).toLowerCase()
                    .replaceAll("[^a-z]", "");
            for (int i = 0; i < allFile.length(); i++) {
                set.add(allFile.charAt(i));
            }
        } catch (NoSuchFileException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator<Character> iterator = set.iterator();
        for (int i = 0; i < count; i++) {
            if (iterator.hasNext()) {
                result.append(iterator.next());
            }
        }
        return result.toString();
    }
}

