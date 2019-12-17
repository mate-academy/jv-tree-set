package core.basesyntax;

import java.io.File;
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
        String getString = getStringFromFile(fileName).toLowerCase();

        Set<Character> set = new TreeSet();
        for (int i = 0; i < getString.length(); i++) {
            if (Character.isLetter(getString.charAt(i))) {
                set.add(getString.charAt(i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if (i < set.toArray().length) {
                stringBuilder.append(set.toArray()[i]);
            }
        }
        return stringBuilder.toString();
    }

    private String getStringFromFile(String file) throws IOException {
        checkFile(file);
        return Files.readString(Paths.get(file));
    }

    private void checkFile(String file) throws IOException {
        File getFile = new File(file);
        if (!getFile.exists()) {
            throw new IOException();
        }
    }
}
