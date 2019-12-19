package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
    public String getUniqueCharacters(String fileName) throws IOException {
        if (!new File(fileName).exists()) {
            throw new FileNotFoundException("The file doesn`t exist");
        }
        String string = Files.readString(Paths.get(fileName));
        string = string.toLowerCase().replaceAll("[^a-z]", "");
        Set<Character> set = new TreeSet<>();
        for (char ch : string.toCharArray()) {
            set.add(ch);
        }
        StringBuilder result = new StringBuilder();
        List<Character> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            if (i == 5) {
                break;
            }
            result.append(list.get(i));
        }
        return result.toString();
    }
}
