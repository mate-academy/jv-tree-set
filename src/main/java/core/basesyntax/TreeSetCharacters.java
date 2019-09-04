package core.basesyntax;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * Реалізуйте метод `getUniqueCharacters(String fileName)` який приймає як параметр назву файлу.
 * Для цього використовуйте TreeSet. Файл містить букви латинського алфавіту і розділові знаки.
 * Метод повинен відсортувати всі букви по алфавіту і повернути строку з 5 різних букв без
 * розділових знаків.
 * Якщо у файлі міститься менше п'яти різних букв, то потрібно повернути їх усі.
 * Можливий випадок, коли переданого файлу не існує, в такому разі потрібно викинути помилку
 * про відсутність файлу.
 * Приклад 1: ur-BvT?^ ra w; p
 * Результат 1: abprt
 * Приклад 2: A _f*c a?F
 * Результат 2: acf
 */
public class TreeSetCharacters {
    private static final int RESULT_LENGTH = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        Set<Character> characters = new TreeSet<>();
        try (FileReader reader = new FileReader(new File(fileName))) {
            int character;
            while ((character = reader.read()) != -1) {
                if (Character.isLetter(character)) {
                    character = Character.toLowerCase(character);
                    characters.add((char) character);
                }
            }
        }
        StringBuilder line = new StringBuilder();
        for (char character : characters) {
            line.append(character);
            if (line.length() == RESULT_LENGTH) {
                break;
            }
        }
        return line.toString();
    }
}
