package arrays_and_strings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class URLifyTest {
    private URLify underTest;

    @Before
    public void setUp() {
        underTest = new URLify();
    }

    @Test
    public void toUrl_withWordsAndOrSpaces_shouldReturnUrlifiedString() {
        String input = "Mr John Smith";
        char[] expected = "Mr%20John%20Smith".toCharArray();
        assertArrayEquals(expected, underTest.toUrl(input.toCharArray(), 13));

        input = "John";
        expected = "John".toCharArray();
        assertArrayEquals(expected, underTest.toUrl(input.toCharArray(), 4));
    }

    @Test
    public void toUrl_withZeroTrueLength_shouldReturnEmptyString() {
        String input = "";
        char[] expected = "".toCharArray();
        assertArrayEquals(expected, underTest.toUrl(input.toCharArray(), 0));
    }

    @Test
    public void toUrl_withWordsAndSpacesZeroTrueLength_shouldReturnEmptyString() {
        String input = "Mr John Smith";
        char[] expected = "".toCharArray();
        assertArrayEquals(expected, underTest.toUrl(input.toCharArray(), 0));
    }

    @Test
    public void toUrl_withExtraWordsLessTrueLength_shouldReturnUrlifiedUptoGivenLength() {
        String input = "Mr John Smith         ";
        char[] expected = "Mr%20John%20Smith".toCharArray();
        assertArrayEquals(expected, underTest.toUrl(input.toCharArray(), 13));
    }
}