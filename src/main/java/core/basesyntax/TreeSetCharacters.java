package core.basesyntax;

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
    private static final int SYMBOL_QUANTITY = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        Set<Character> symbols = new TreeSet<>();

        for (String chars : Files.readAllLines(Paths.get(fileName))) {
            for (Character element : chars.toLowerCase().toCharArray()) {
                if (Character.isLetter(element)) {
                    symbols.add(element);
                }
            }
        }

        int i = 0;
        StringBuilder result = new StringBuilder();
        for (Character character : symbols) {
            result.append(character);
            if (++i == SYMBOL_QUANTITY) {
                break;
            }
        }

        return result.toString();
    }
}
