package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class TreeSetCharactersTest {
    private static final String FIVE_CHARACTERS = "abdhi";
    private static final String FOUR_CHARACTERS = "ejlo";
    private static final String WITHOUT_CHARACTERS = "";

    @Test
    public void getFiveUniqueCharacters() {
        TreeSetCharacters characters = new TreeSetCharacters();
        String actualResult = characters.getUniqueCharacters("file1.txt");
        Assert.assertEquals("Test faild with result: " + actualResult,
                FIVE_CHARACTERS, actualResult);
    }

    @Test
    public void getLessThenFiveUniqueCharacters() {
        TreeSetCharacters characters = new TreeSetCharacters();
        String actualResult = characters.getUniqueCharacters("file2.txt");
        Assert.assertEquals("Test faild with result: " + actualResult,
                FOUR_CHARACTERS, actualResult);
    }

    @Test
    public void getEmptyUniqueCharacters() {
        TreeSetCharacters characters = new TreeSetCharacters();
        String actualResult = characters.getUniqueCharacters("file3.txt");
        Assert.assertEquals("Test faild with result: " + actualResult,
                WITHOUT_CHARACTERS, actualResult);
    }
}
