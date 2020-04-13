package core.basesyntax;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetCharacters {
    public String getUniqueCharacters(String fileName) throws IOException {
        TreeSet<Character> treeSet = new TreeSet<>();
        try (FileReader fileReader = new FileReader(fileName)) {
            int data = fileReader.read();
            System.out.println(data);
            while (data != -1) {
                if (Character.isAlphabetic(data)) {
                    treeSet.add((char) Character.toLowerCase(data));
                }
                data = fileReader.read();
            }
        }
        Iterator<Character> iterator = treeSet.iterator();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (count < 5 && count < treeSet.size()) {
            sb.append(iterator.next());
            count++;
        }
        return sb.toString();
    }
}
