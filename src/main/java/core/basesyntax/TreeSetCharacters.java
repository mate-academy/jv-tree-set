package core.basesyntax;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
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
        StringBuilder fileContent = new StringBuilder("");
        try (FileReader checkFile = new FileReader(fileName)) {
            int charContent;
            while ((charContent = checkFile.read()) != -1) {
                fileContent.append((char) charContent);
            }
        }
        String fileNameEdited = fileContent.toString().toLowerCase();
        TreeSet<Character> fileNameChars = new TreeSet<>();
        for (int i = 0; i < fileNameEdited.length(); i++) {
            if (Character.isLetter(fileNameEdited.charAt(i))) {
                fileNameChars.add(fileNameEdited.charAt(i));
            }
        }
        StringBuilder fileNameToReturn = new StringBuilder("");
        Iterator iterator = fileNameChars.iterator();
        int i = 0;
        while (i != 5 && iterator.hasNext()) {
            fileNameToReturn.append(iterator.next());
            i++;
        }
        return fileNameToReturn.toString();
    }
}
