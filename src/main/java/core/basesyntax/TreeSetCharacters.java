package core.basesyntax;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
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

        TreeSet<Character> charSet = new TreeSet<>();
        try (FileReader fr = new FileReader(fileName)) {
            Scanner reader = new Scanner(fr);
            while (reader.hasNextLine()) {
                char[] chars = reader.nextLine().toLowerCase().toCharArray();
                for (char ch : chars) {
                    if (Character.isLetter(ch)) {
                        charSet.add(ch);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Character ch : charSet) {
                sb.append((char) ch);
                if (sb.length() == 5) {
                    return sb.toString();
                }
            }
            return sb.toString();
        }
    }
}
