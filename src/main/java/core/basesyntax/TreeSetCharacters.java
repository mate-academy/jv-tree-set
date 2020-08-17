package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
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
        StringBuilder text = new StringBuilder();
        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            while (scanner.hasNextLine()) {
                text.append(scanner.nextLine().toLowerCase().replaceAll("[^a-z]", ""));
            }
        } catch (IOException e) {
            throw new FileNotFoundException("Mentioned file does not exist");
        }
        Set<Character> treeSet = new TreeSet<>();
        for (int i = 0; i < text.length(); i++) {
            treeSet.add(text.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        int size = 0;
        Iterator<Character> iterator = treeSet.iterator();
        while (iterator.hasNext() && size < 5) {
            result.append(iterator.next());
            size++;
        }
        return new String(result);
    }
}
