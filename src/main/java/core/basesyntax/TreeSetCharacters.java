package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
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
        if (!new File(fileName).exists()) {
            throw new FileNotFoundException("Such file doesn't exist!");
        }
        StringBuilder result = new StringBuilder();
        char[] chars = Files.readString(Paths.get(fileName)).toLowerCase()
                .replaceAll("[^A-Za-z]", "").toCharArray();
        Set<Character> fileCharacters = new TreeSet<>();
        for (Character fileCharacter : chars) {
            fileCharacters.add(fileCharacter);
        }
        for (Character fileCharacter : fileCharacters) {
            result.append(fileCharacter);
            if (result.length() >= 5) {
                break;
            }
        }
        return result.toString();
    }
}

