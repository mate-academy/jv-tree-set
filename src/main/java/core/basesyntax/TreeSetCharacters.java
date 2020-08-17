package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        Path filePath = Paths.get(fileName);
        Set<String> treeSet = new TreeSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String buffer;
            while ((buffer = reader.readLine()) != null) {
                buffer = buffer.toLowerCase().replaceAll("[^a-z]", "");
                for (int i = 0; i < buffer.length(); i++) {
                    treeSet.add(buffer.charAt(i) + "");
                }
            }
        } catch (IOException e) {
            throw new FileNotFoundException(e.getMessage());
        }

        for (String s : treeSet) {
            stringBuilder.append(s);
            if (stringBuilder.length() >= 5) {
                break;
            }
        }

        return stringBuilder.toString();
    }
}
