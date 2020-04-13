package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
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
        StringBuilder allDocument = new StringBuilder();
        try (FileReader reader = new FileReader(fileName)) {
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine()) {
                allDocument.append(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File Not Found"+e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<Character> result = new TreeSet<>();
        for (int i = 0; i < allDocument.length(); i++) {
            if (Character.isAlphabetic(allDocument.charAt(i))) {
                result.add(Character.toLowerCase(allDocument.charAt(i)));
            }
        }
        allDocument = new StringBuilder("");
        Iterator<Character> itr = result.iterator();
        while (itr.hasNext()) {
            allDocument.append(itr.next());
            if (allDocument.length() == 5) {
                break;
            }
        }
        return allDocument.toString();
    }
}
