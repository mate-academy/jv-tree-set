package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    private static final int ITEM_TO_RETURN = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        String result = "";
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName));) {
            TreeSet<Character> stringTreeSet = new TreeSet<>();
            while (fileReader.ready()) {
                String string = fileReader.readLine().toLowerCase().replaceAll("[^a-zA-Z]", "");
                for (int i = 0; i < string.length(); i++) {
                    if (!stringTreeSet.contains(string.charAt(i))) {
                        stringTreeSet.add(string.charAt(i));
                    }
                }
            }
            int setSize = stringTreeSet.size();
            for (int i = 0; i < setSize; i++) {
                if (i < ITEM_TO_RETURN) {
                    result += stringTreeSet.first();
                    stringTreeSet.remove(stringTreeSet.first());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
