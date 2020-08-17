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
    public String getUniqueCharacters(String fileName) throws IOException {
        StringBuilder data = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileName)) {
            Scanner scan = new Scanner(fileReader);
            while (scan.hasNextLine()) {
                data.append(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File is not found");
        }
        String stringForTree = data.toString().toLowerCase().replaceAll("[^a-z]", "");
        Set<Character> tree = new TreeSet<>();
        for (int i = 0; i < stringForTree.length(); i++) {
            tree.add(stringForTree.charAt(i));
        }
        data.delete(0, data.length());
        for (Character letter : tree) {
            data.append(letter);
        }
        return data.length() < 6 ? data.toString() : data.toString().substring(0, 5);
    }
}
