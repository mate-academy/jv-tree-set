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
    public String getUniqueCharacters(String fileName) throws IOException {
        Set<Character> set = new TreeSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String charAsString = ((char) reader.read() + "")
                        .replaceAll("[_\\W\\d]", "").toLowerCase();
                if (!charAsString.equals("")) {
                    set.add(charAsString.toCharArray()[0]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Error: File not found.");
        } catch (IOException e) {
            throw new IOException(e);
        }

        Character[] characters = set.toArray(new Character[set.size()]);
        Arrays.sort(characters);

        StringBuilder sb = new StringBuilder();
        for (Character c : characters) {
            sb.append(c);
        }

        String result = sb.toString();
        return result.length() > 5 ? result.substring(0, 5) : result;
    }
}
