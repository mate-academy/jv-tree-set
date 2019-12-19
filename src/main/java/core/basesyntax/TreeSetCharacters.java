package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
    public String getUniqueCharacters(String fileName) throws FileNotFoundException {
        String result = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Set<Character> chars = new TreeSet<>();

            while ((line = bufferedReader.readLine()) != null) {
                String cleanLine = line.replaceAll("[^A-Za-z]", "");
                for (Character c: cleanLine.toLowerCase().toCharArray()) {
                    chars.add(c);
                }
            }

            StringBuilder charsSet = new StringBuilder();
            for (Character c: chars) {
                charsSet.append(c);
            }
            int n = Math.min(chars.size(), 5);
            result = charsSet.toString().substring(0, n);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new FileNotFoundException("There is no such file");
        }
        return result;
    }
}
