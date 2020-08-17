package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
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
    public String getUniqueCharacters(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Set<String> fileNameTree = new TreeSet<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] lineArray = sc.nextLine().toLowerCase()
                        .replaceAll("[^a-zA-Z]", "").split("");
                for (int i = 0; i < lineArray.length; i++) {
                    fileNameTree.add(lineArray[i]);
                }
            }
        } catch (FileNotFoundException e) {
            throw e;
        }
        StringBuilder finalStr = new StringBuilder();
        for (String a : fileNameTree) {
            finalStr = finalStr.append(a);
        }
        return (finalStr.length() <= 5) ? String.valueOf(finalStr) : finalStr.substring(0, 5);
    }
}
