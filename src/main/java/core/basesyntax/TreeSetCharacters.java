package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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
        if (!Files.exists(Paths.get(fileName))) {
            throw new FileNotFoundException("No file found!");
        }

        List<String> stringList = null;
        try {
            stringList = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            System.out.println("Wrong input!");
        }

        StringBuilder oneString = new StringBuilder();

        for (String str : stringList) {
            oneString.append(str.toLowerCase());
        }

        TreeSet<Character> charSet = new TreeSet<>();
        for (char ch : oneString.toString().replaceAll("[^a-z]+", "").toCharArray()) {
            charSet.add(ch);
        }

        StringBuilder answer = new StringBuilder();
        for (char ch : charSet) {
            answer.append(ch);
        }
        return (answer.length() <= 5) ? answer.toString() : answer.subSequence(0,5).toString();
    }
}
