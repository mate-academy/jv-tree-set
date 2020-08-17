package core.basesyntax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    public static final int SYMBOLS_NUMBER = 5;

    public String getUniqueCharacters(String fileName) throws FileNotFoundException {
        Set<Character> set = new TreeSet<>();
        try (FileInputStream fin = new FileInputStream(fileName)) {
            int symbol = 0;
            while ((symbol = fin.read()) != -1) {
                if (Character.isLetter((char) symbol)) {
                    set.add(Character.toLowerCase((char) symbol));
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + fileName + " does not exist");
        } catch (IOException e) {
            throw new RuntimeException("File " + fileName + " does not exist");
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = set.iterator();
        int count = 0;
        while (iterator.hasNext() && count < SYMBOLS_NUMBER) {
            stringBuilder.append(iterator.next());
            count++;
        }
        return stringBuilder.toString();
    }
}
