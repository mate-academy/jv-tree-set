package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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

    private static final int SIZE = 5;

    public String getUniqueCharacters(String fileName) throws IOException {

        StringBuilder lines = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.append(line);
            }
        }
        String text = lines.toString().toLowerCase()
                .replaceAll("(\\d|\\W)", "");
        Set<Character> chars = new TreeSet<>();
        for (int i = 0; i < text.length(); i++) {
            chars.add(text.charAt(i));
        }
        StringBuilder set = new StringBuilder();
        int index = 0;
        for (Character character : chars) {
            set.append(character);
            index++;
            if (index == SIZE) {
                break;
            }
        }
        return set.toString();
    }
}
