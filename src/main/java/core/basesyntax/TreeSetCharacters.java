package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
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

        Set<String> characters = new TreeSet<>();
        try (FileReader reader = new FileReader(fileName)) {
            if (!Files.exists(Paths.get(fileName))) {
                throw new FileNotFoundException("File not found");
            }
            int symbol;
            while ((symbol = reader.read()) != -1) {
                characters.add(Character.toString(symbol)
                        .toLowerCase()
                        .replaceAll("[^a-z]", ""));
            }

        }
        String result = characters.toString()
                .replaceAll(", ", "")
                .replace("[", "")
                .replace("]","");
        return characters.size() > 5
                ? result.substring(0,5) : result;
    }
}
