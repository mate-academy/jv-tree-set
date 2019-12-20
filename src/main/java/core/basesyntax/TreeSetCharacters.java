package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
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

        TreeSet<Character> set = new TreeSet<Character>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1.compareTo(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        if (fileName != null) {
            try
                    (FileReader fileReader = new FileReader(fileName);
                     BufferedReader reader = new BufferedReader(fileReader);) {
                while (reader.ready()) {
                    sb.append(reader.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            throw new
                    FileNotFoundException("Файлу не існує");
        }

        String str = sb.toString().toLowerCase();
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (Character.isLetter(array[i])) {
                set.add(array[i]);
            }
        }
        String res = "";
        if (set.isEmpty()) {
            return res;
        }
        if (set.size() > 5) {
            for (int i = 0; i < 5; i++) {
                res += set.pollFirst();
            }
        }
        if (set.size() < 5) {
            for (int i = 0; i < set.size() + i; i++) {
                res += set.pollFirst();
            }
        }
        return res;
    }
}
