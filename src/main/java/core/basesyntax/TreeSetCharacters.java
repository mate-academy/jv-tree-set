package core.basesyntax;

import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class TreeSetCharacters {
    public String getUniqueCharacters(String fileName) throws IOException {
        TreeSet<Character> treeSet = new TreeSet<>();
        try (FileReader fileReader = new FileReader(fileName)) {
            while (fileReader.ready()) {
                char a = (char) fileReader.read();
                if (Character.isLetter(a)) {
                    treeSet.add(Character.toLowerCase(a));
                }
                fileReader.ready();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character s : treeSet) {
            if (sb.length() == 5) {
                break;
            }
            sb.append(s);
        }
        return sb.toString();
    }
}
