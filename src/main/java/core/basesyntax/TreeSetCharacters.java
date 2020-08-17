package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetCharacters {
    private static final int MAX_NUMBER = 5;

    public String getUniqueCharacters(String fileName) throws IOException {
        TreeSet<Character> letters = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int character = reader.read();
            while (character != -1) {
                if (Character.isLetter(character)) {
                    letters.add((char) Character.toLowerCase(character));
                }
                character = reader.read();
            }
        }
        StringBuilder response = new StringBuilder();
        Iterator<Character> iterator = letters.iterator();
        while (iterator.hasNext() && response.length() < MAX_NUMBER) {
            response.append(iterator.next());
        }
        return response.toString();
    }
}
