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
    public String getUniqueCharacters(String fileName) throws IOException {
        StringBuilder charsFromFile = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                charsFromFile.append(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException exception) {
            throw new FileNotFoundException(exception.getMessage());
        }
        char[] charsArray = new char[charsFromFile.length()];
        charsFromFile.getChars(0, charsFromFile.length(), charsArray, 0);
        Set<Character> characters = new TreeSet<>();
        for (int i = 0; i < charsArray.length; i++) {
            if (Character.isAlphabetic(charsArray[i])) {
                characters.add(Character.toLowerCase(charsArray[i]));
            }
        }
        String result = "";
        for (Character character : characters) {
            result += character;
        }
        return result.length() > 5 ? result.substring(0, 5) : result;
    }
}
