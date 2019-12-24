package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
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
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Set<Character> mySet = new TreeSet<>();
        String str = "";
        while ((str = bufferedReader.readLine()) != null) {
            String newString = str.trim().toLowerCase()
                    .replaceAll("[^a-z]", "");

            for (int i = 0; i < newString.length(); i++) {
                if (Character.isLetter(newString.charAt(i))) {
                    mySet.add(newString.charAt(i));
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character myChar :
                mySet) {
            stringBuilder.append(myChar);
            if (stringBuilder.length() == 5) {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
