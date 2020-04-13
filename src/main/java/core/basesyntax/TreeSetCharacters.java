package core.basesyntax;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        TreeSet<Character> characterTreeSet = new TreeSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            String text = bufferedReader.readLine();
            String s = text.replaceAll("[^a-zA-z]", "").toLowerCase();
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                characterTreeSet.add(aChar);
            }

            for (Character c : characterTreeSet) {
                stringBuilder.append(c);
                if(stringBuilder.length()==5){
                    return stringBuilder.toString();
                }
            }
        }


        return stringBuilder.toString();
//        TreeSet<Character> characterTreeSet = new TreeSet<>();
//        StringBuilder stringBuilder = new StringBuilder();
//
//        String text = Files.readString(Paths.get(fileName)).replaceAll("[^a-zA-z]", "").toLowerCase();
//        char[] chars = text.toCharArray();
//        for (char aChar : chars) {
//            characterTreeSet.add(aChar);
//        }
//
//
//        int count = 0;
//        for (Character c : characterTreeSet) {
//            stringBuilder.append(c);
//            count++;
//            if (count == 5) {
//                break;
//            }
//        }
//
//        return stringBuilder.toString();

    }
}



