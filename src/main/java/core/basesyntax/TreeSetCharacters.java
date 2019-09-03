package core.basesyntax;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
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
        InputStream inputStream = Files.newInputStream(Paths.get(fileName));
        int bytesOfFile;
        StringBuilder onlyLetters = new StringBuilder();
        do {
            bytesOfFile = inputStream.read();
            if ((bytesOfFile > 64 && bytesOfFile < 91) || (bytesOfFile > 96 && bytesOfFile < 123)) {
                onlyLetters = onlyLetters.append((char)bytesOfFile);
            }
        } while (bytesOfFile != -1);
        String lowerCase = new String(onlyLetters).toLowerCase();
        Set<String> letters = new TreeSet<String>(Arrays.asList(lowerCase.split("")));
        Iterator alphabet = letters.iterator();
        String result = "";
        for (int i = 0; i < 5 && alphabet.hasNext(); i++) {
            result += alphabet.next();
        }
        return result;
    }
}
