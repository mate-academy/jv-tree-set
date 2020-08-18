package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetCharacters {
    public String getUniqueCharacters(String fileName) throws IOException {
        StringBuilder characters = new StringBuilder();
        Set<Character> setOfCharacters = new TreeSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                char[] chars = line.toLowerCase().replaceAll("[^a-z]", "").toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    setOfCharacters.add(chars[i]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        }
        for (Character element : setOfCharacters) {
            if (characters.length() == 5) {
                return characters.toString();
            }
            characters.append(element);
        }
        return characters.toString();
    }
}
