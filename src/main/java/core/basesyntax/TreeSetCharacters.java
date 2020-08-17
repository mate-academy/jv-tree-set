package core.basesyntax;

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
    private static final int MAX_ANSWER_ELEMENTS = 5;
    private static final int END_OF_FILE_CODE = 65535;

    public String getUniqueCharacters(String fileName) throws IOException {
        Set<Character> sortAnswer = new TreeSet<>();
        try (FileReader fileReader = new FileReader(fileName)) {
            char symbol = (char)fileReader.read();
            while (symbol != END_OF_FILE_CODE) {
                if (Character.isLetter(symbol)) {
                    sortAnswer.add(Character.toLowerCase(symbol));
                }
                symbol = (char)fileReader.read();
            }
        }
        int counter = 0;
        StringBuilder answer = new StringBuilder();
        for (Character element : sortAnswer) {
            answer.append(element);
            counter++;
            if (counter == MAX_ANSWER_ELEMENTS) {
                break;
            }
        }
        return answer.toString();
    }
}
