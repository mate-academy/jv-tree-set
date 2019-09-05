package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
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
 * <p>Приклад 1: ur-BvT?^ ra w; p
 * Результат 1: abprt</p>
 * <p>Приклад 2: A _f*c a?F
 * Результат 2: acf</p>
 */
public class TreeSetCharacters {
    private static final int LENGTH_FIFTH = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        Set<Character> set = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int countOfSmbl = reader.read();
            do {
                if (Character.isLetter(countOfSmbl)) {
                    set.add((char) Character.toLowerCase(countOfSmbl));
                }
                countOfSmbl = reader.read();
            } while (countOfSmbl != -1);
            StringBuilder stringBuilder = new StringBuilder();
            int count = 1;
            for (Character chars : set) {
                stringBuilder.append(chars);
                if (count == set.size() || count == LENGTH_FIFTH) {
                    break;
                }
                count++;
            }
            return stringBuilder.toString();
        }
    }
}
