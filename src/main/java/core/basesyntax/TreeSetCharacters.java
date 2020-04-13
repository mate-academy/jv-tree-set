package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetCharacters {
    public String getUniqueCharacters(String fileName) throws FileNotFoundException {
        TreeSet<Character> treeSet = new TreeSet<>();
        try (FileReader fileReader = new FileReader(fileName)) {
            int data = fileReader.read();
            while (data != -1) {
                if (Character.isAlphabetic(data)) {
                    treeSet.add((char) Character.toLowerCase(data));
                }
                data = fileReader.read();
            }
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
        Iterator<Character> iterator = treeSet.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (iterator.hasNext()) {
            if (i == 5) {
                break;
            }
            stringBuilder.append(iterator.next());
            i++;
        }
        return stringBuilder.toString();
    }
}
