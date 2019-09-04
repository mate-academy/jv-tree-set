package core.basesyntax;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    static final int NUMBER_LETTERS = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        try (InputStream inputStream = Files.newInputStream(Paths.get(fileName))) {
            int bytesOfFile;
            Set<Character> chars = new TreeSet<>();

            do {
                bytesOfFile = inputStream.read();
                Character character = Character.toLowerCase((char)bytesOfFile);
                if (isLatterChar(character)) {
                    chars.add(character);
                }
            } while (bytesOfFile != -1);

            Iterator alphabet = chars.iterator();
            StringBuilder result = new StringBuilder("");
            for (int i = 0; i < NUMBER_LETTERS && alphabet.hasNext(); i++) {
                result.append(alphabet.next());
            }
            return result.toString();
        }
    }

    private boolean isLatterChar(char character) {
        return (character >= 'A' && character <= 'Z') || (character >= 'a' && character <= 'z');
    }
}
