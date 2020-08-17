package core.basesyntax;

import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class TreeSetCharacters {
    public String getUniqueCharacters(String fileName) throws IOException {
        StringBuilder resultString = new StringBuilder();
        TreeSet<Character> charSet = new TreeSet<Character>();
        try (FileReader fileReader = new FileReader(fileName)) {
            int symbol;
            while ((symbol = fileReader.read()) != -1) {
                charSet.add((char) Character.toLowerCase(symbol));
            }
            for (Character ch: charSet) {
                if (Character.isLetter(ch) && (resultString.length() < 5)) {
                    resultString.append(ch);
                }
            }
        }
        return resultString.toString().toLowerCase();
    }
}
