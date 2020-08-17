package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        String data = readFile(fileName);
        data = data.replaceAll("(\\W|\\d)", "").toLowerCase();
        Set<Character> chars = getCharsFromString(data);
        return setToString(chars);
    }

    private String setToString(Set<Character> chars) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        for (Character letter : chars) {
            result.append(letter);
            index++;
            if (index == 5) {
                break;
            }
        }
        return result.toString();
    }

    private Set<Character> getCharsFromString(String data) {
        Set<Character> chars = new TreeSet<>();
        for (int i = 0; i < data.length(); i++) {
            chars.add(data.charAt(i));
        }
        return chars;
    }

    private String readFile(String filename) throws IOException {
        StringBuilder lines = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.append(line);
            }
        }
        return lines.toString();
    }
}
