package core.basesyntax;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetCharacters {
    public String getUniqueCharacters(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder chapter = new StringBuilder();
        TreeSet<Character> treeSet = new TreeSet<>();
        FileReader reader = new FileReader(fileName);
        while (reader.ready()) {
            stringBuilder.append((char) reader.read());
        }
        reader.close();
        char[] chars = stringBuilder.toString().toCharArray();
        for (Character i : chars) {
            if (Character.isLetter(i)) {
                treeSet.add(Character.toLowerCase(i));
            }
        }
        Iterator<Character> iterator = treeSet.iterator();
        int x = 5;
        while (iterator.hasNext() && x > 0) {
            chapter.append(iterator.next());
            x--;
        }
        return chapter.toString();
    }
}
