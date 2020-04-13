package core.basesyntax;

import java.util.Comparator;

public class Compare implements Comparator<Character> {

    @Override
    public int compare(Character o1, Character o2) {
        return o1 < o2 ? -1 : o1 == o2 ? 0 : 1;
    }
}
