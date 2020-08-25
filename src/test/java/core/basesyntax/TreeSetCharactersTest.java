package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class TreeSetCharactersTest {
    private static final String FIVE_CHARACTERS = "abdhi";
    private static final String FOUR_CHARACTERS = "ejlo";
    private static final String WITHOUT_CHARACTERS = "";

    @Test
    public void getFiveUniqueCharacters() throws IOException {
        TreeSetCharacters characters = new TreeSetCharacters();
        String actualResult = characters.getUniqueCharacters("file1.txt");
        Assert.assertEquals("Test failed with result: " + actualResult,
                FIVE_CHARACTERS, actualResult);
    }

    @Test
    public void getLessThenFiveUniqueCharacters() throws IOException {
        TreeSetCharacters characters = new TreeSetCharacters();
        String actualResult = characters.getUniqueCharacters("file2.txt");
        Assert.assertEquals("Test failed with result: " + actualResult,
                FOUR_CHARACTERS, actualResult);
    }

    @Test
    public void getEmptyUniqueCharacters() throws IOException {
        TreeSetCharacters characters = new TreeSetCharacters();
        String actualResult = characters.getUniqueCharacters("file3.txt");
        Assert.assertEquals("Test failed with result: " + actualResult,
                WITHOUT_CHARACTERS, actualResult);
    }

    @Test
    public void getEmptyUniqueCharactersFromNumbers() throws IOException {
        TreeSetCharacters characters = new TreeSetCharacters();
        String actualResult = characters.getUniqueCharacters("file4.txt");
        Assert.assertEquals("Test failed with result: " + actualResult,
                WITHOUT_CHARACTERS, actualResult);
    }

    @Test (expected = FileNotFoundException.class)
    public void getExceptionWhenFileNotExist() throws IOException {
        TreeSetCharacters characters = new TreeSetCharacters();
        characters.getUniqueCharacters("file");
    }
}
