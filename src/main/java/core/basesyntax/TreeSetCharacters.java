package core.basesyntax;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
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
    public String getUniqueCharacters(String fileName) throws FileNotFoundException {
        StringBuilder textOfFile = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String text;
            while ((text = reader.readLine()) != null) {
                textOfFile.append(text);
            }
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
        Set setOfChars = new TreeSet();
        for (int i = 0; i < textOfFile.length(); i++) {
            if (Character.isAlphabetic(textOfFile.charAt(i))) {
                setOfChars.add(Character.toLowerCase(textOfFile.charAt(i)));
            }
        }
        StringBuilder result = new StringBuilder();
        for (Object character: setOfChars) {
            result.append(character);
            if (result.length() == 5) {
                break;
            }
        }
        return result.toString();
    }
}
