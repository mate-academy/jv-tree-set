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
    private static final int ELEMENTS_NUMBER = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        StringBuilder returnData = new StringBuilder();
        TreeSet<Character> treeSet = new TreeSet<Character>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                returnData.append(fileReader.readLine());
            }
        }
        char[] charSequence = returnData.toString().replaceAll("[^a-zA-Z]", "")
                .toLowerCase().toCharArray();
        returnData.setLength(0);
        for (Character item : charSequence) {
            treeSet.add(item);
        }
        int i = 0;
        for (Character item : treeSet) {
            returnData.append(item);
            if (++i == ELEMENTS_NUMBER) {
                break;
            }
        }
        return returnData.toString();
    }
}
