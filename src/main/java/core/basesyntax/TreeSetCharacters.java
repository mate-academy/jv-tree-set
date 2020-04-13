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
        sb.append(treeSet.toString().replaceAll(" |,|\\]|\\[",""));
        return treeSet.size() < 5 ? sb.toString() : sb.toString().substring(0, 5);
    }
}
