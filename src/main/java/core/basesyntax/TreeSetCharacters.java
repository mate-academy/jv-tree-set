package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;

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
    private static final int LETTERS_LIMIT = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        Set<Character> characters;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            characters = reader.lines()
                    .flatMapToInt(String::chars)
                    .mapToObj(i -> (char) i)
                    .filter(Character::isAlphabetic)
                    .map(Character::toLowerCase)
                    .collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        }
        return characters.stream()
                .limit(LETTERS_LIMIT)
                .collect(Collector.of(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString));
    }
}
