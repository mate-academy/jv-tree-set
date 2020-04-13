package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
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
        TreeSet<Character> set = new TreeSet<>();
        try (FileReader fileReader = new FileReader(fileName)) {
            int numberOfSymbol;
            while ((numberOfSymbol = fileReader.read()) != -1) {
                if (Character.isLetter((char) numberOfSymbol)) {
                    set.add((char) Character.toLowerCase(numberOfSymbol));
                }
            }
        } catch (IOException e) {
            throw new FileNotFoundException(fileName + "is not found");
        }
        Iterator<Character> iterator = set.iterator();
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (iterator.hasNext() && i < 5) {
            builder.append(iterator.next());
            i++;
        }
        return builder.toString();
    }
}
