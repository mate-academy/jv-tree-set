package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
    public String getUniqueCharacters(String fileName) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        TreeSet treeSet = new TreeSet();

        try (FileReader fileReader = new FileReader(fileName)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int symbol = bufferedReader.read();
            while (symbol != -1) {
                if (Character.isLetter(symbol)) {
                    treeSet.add((char) Character.toLowerCase(symbol));
                }
                symbol = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new FileNotFoundException("There is no file in our universe!");
        }

        for (Object o : treeSet) {
            stringBuilder.append(o);
            if (stringBuilder.length() == 5) {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
