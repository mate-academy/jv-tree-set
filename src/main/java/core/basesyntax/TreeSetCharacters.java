package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeSet;

public class TreeSetCharacters {
    public String getUniqueCharacters(String fileName) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder chapter = new StringBuilder();
        TreeSet<Character> treeSet = new TreeSet<>();
        try {
            Files.lines(Paths.get(fileName)).forEach(stringBuilder::append);
        } catch (IOException e) {
            throw new FileNotFoundException(e.toString());
        }
        char[] chars = stringBuilder.toString().toCharArray();
        for (Character i : chars) {
            if (Character.isLetter(i)) {
                treeSet.add(Character.toLowerCase(i));
            }
        }
        int x = Math.min(treeSet.size(), 5);
        for (int j = 0; j < x; j++) {
            chapter.append(treeSet.first());
            treeSet.remove(treeSet.first());
        }
        return chapter.toString();
    }
}
