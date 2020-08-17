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
    public String getUniqueCharacters(String fileName) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String inputLine = "";
            while ((inputLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(inputLine.toLowerCase().replaceAll("[^a-z]", ""));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Can't read from file");
        }

        TreeSet<Character> stringSet = new TreeSet<>();
        for (int i = 0; i < stringBuilder.length(); i++) {
            stringSet.add(stringBuilder.charAt(i));
        }

        stringBuilder.setLength(0);
        int resultSize = Math.min(stringSet.size(), 5);
        for (int i = 0; i < resultSize; i++) {
            stringBuilder.append(stringSet.pollFirst());
        }
        return stringBuilder.toString();
    }
}
