package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
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
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(new File(fileName)))) {
            int sumbol;
            while ((sumbol = bufferedReader.read()) != -1) {
                if (Character.isLetter(sumbol)) {
                    String lowwer = String.valueOf((char) sumbol);
                    builder.append(lowwer.toLowerCase());
                }
            }
        }

        Set<Character> remoteDuplicates = new TreeSet<>();
        for (int i = 0; i < builder.length(); i++) {
            remoteDuplicates.add(builder.charAt(i));
        }
        builder.delete(0, builder.length());
        for (Character chars : remoteDuplicates) {
            builder.append(chars);
            if (builder.length() >= 5) {
                break;
            }
        }
        return builder.toString();
    }
}
