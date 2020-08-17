package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    private static final int LENGTH_OF_RESULT_STRING = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileName)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File is not exist");
        }
        char[] clearString = stringBuilder.toString()
                .replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray();
        Set<Character> treeSet = new TreeSet<>();
        for (char c : clearString) {
            treeSet.add(c);
        }
        stringBuilder.setLength(0);
        for (char c : treeSet) {
            while (stringBuilder.length() != LENGTH_OF_RESULT_STRING) {
                stringBuilder.append(c);
                break;
            }
        }
        return stringBuilder.toString();
    }
}
