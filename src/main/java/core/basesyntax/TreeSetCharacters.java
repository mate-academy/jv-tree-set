package core.basesyntax;

import java.io.BufferedReader;
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
    public static String getUniqueCharacters(String fileName)throws IOException {
        int outputLength = 5;
        String line;
        String[] parsed;
        Set<String> treeSet = new TreeSet<String>();
        StringBuffer stringBuilder = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            stringBuilder.append(bufferedReader.readLine());
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            line = stringBuilder.toString().strip().toLowerCase().replaceAll("[^A-Za-z]", "");
            parsed = new String[line.length()];

            for (int i = 0; i < line.length(); i++) {
                parsed[i] = Character.toString(line.charAt(i));
            }
            for (String c : parsed) {
                treeSet.add(c);
            }
            if (treeSet.size() >= outputLength) {
                return treeSet.toString().replaceAll("[^A-Za-z]", "").substring(0, outputLength);
            }
            return treeSet.toString().replaceAll("[^A-Za-z]", "");
        }
    }
}
