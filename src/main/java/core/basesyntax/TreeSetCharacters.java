package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                result.append(line.replaceAll("[^a-z]", ""));
            }
        }
        TreeSet<Character> bufferedTree = new TreeSet<>();
        for (Character ch: result.toString().toCharArray()) {
            bufferedTree.add(ch);
        }
        List<Character> end = new ArrayList<>();
        end.addAll(bufferedTree);
        result = new StringBuilder();
        for (int i = 0; i < end.size(); i++) {
            if (i == 5) {
                break;
            }
            result.append(end.get(i));
        }
        return result.toString();
    }
}
