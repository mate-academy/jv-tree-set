package core.basesyntax;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileReader;

import java.io.IOException;

import java.util.Arrays;


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
    StringBuilder stringBuilder = new StringBuilder();

    public String getUniqueCharacters(String fileName) throws IOException {
        try (FileReader fileReader = new FileReader(new File(fileName));
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        String toProcess = stringBuilder.toString().toLowerCase().replaceAll("[^a-z]", "");
        stringBuilder.setLength(0);
        toProcess.chars().distinct().forEach(c -> stringBuilder.append((char) c));
        char[] tempArray = stringBuilder.toString().toCharArray();
        Arrays.sort(tempArray);
        if (tempArray.length <= 5) {
            return new String(tempArray);
        }
        stringBuilder.setLength(0);
        for (int i = 0; i < 5; i++) {
            stringBuilder.append(tempArray[i]);
        }
        return stringBuilder.toString();
    }
}
