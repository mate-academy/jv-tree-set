package core.basesyntax;

import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class TreeSetCharacters {
    public static void main(String[] args) throws IOException {
        FileReader filereader = new FileReader("file1.txt");
        boolean data = filereader.ready();
        String b = "";
        while (data) {
            char a = (char) filereader.read();
            if (Character.isAlphabetic(a)) {
                b = b + a;
            }
            data = filereader.ready();
        }
    }

    public String getUniqueCharacters(String fileName) throws IOException {
        TreeSet<Character> treeSet = new TreeSet<>();
        try (FileReader fileReader = new FileReader(fileName)) {
            boolean hasNext = fileReader.ready();
            while (hasNext) {
                char a = (char) fileReader.read();
                if (Character.isAlphabetic(a)) {
                    treeSet.add(Character.toLowerCase(a));
                }
                hasNext = fileReader.ready();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(treeSet.toString().replaceAll(" |,|\\]|\\[",""));
        return treeSet.size() < 5 ? sb.toString() : sb.toString().substring(0, 5);
    }
}
