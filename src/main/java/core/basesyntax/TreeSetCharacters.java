package core.basesyntax;

import java.io.File;
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
    private static final int MAX_OUTPUT_LENGTH = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        File file = new File(fileName);
        TreeSet<Character> treeSet = new TreeSet<>();

        try (FileReader fileReader = new FileReader(fileName)) {
            Character character;
            for (int i = fileReader.read(); i != -1; i = fileReader.read()) {
                if (Character.isAlphabetic(i)) {
                    treeSet.add(Character.toLowerCase((char) i));
                }
            }
        } catch (IOException e) {
            throw new FileNotFoundException();
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; treeSet.size() > 0 && i < MAX_OUTPUT_LENGTH; i++) {
            stringBuilder.append(treeSet.pollFirst());
        }
        return stringBuilder.toString();
    }
}
