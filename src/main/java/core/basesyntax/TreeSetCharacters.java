package core.basesyntax;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
 * <p>
 * Use try with resources.
 * Use Character and its methods.
 * Don’t use java.util.ArrayList.
 * Don’t put all code in try block.
 * Use StringBuilder instead of String.
 * Variable names should be informative.
 */

public class TreeSetCharacters {
    public String getUniqueCharacters(String fileName) throws IOException {
        Set<Character> charSet = new TreeSet<>();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName))) {
            while (reader.ready()) {
                Character character = (char) reader.read();
                if (Character.isLetter(character)) {
                    charSet.add(Character.toLowerCase(character));
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (Character character : charSet) {
            answer.append(character);
        }
        if (answer.length() > 5) {
            return answer.toString().substring(0, 5);
        }
        return answer.toString();
    }
}
