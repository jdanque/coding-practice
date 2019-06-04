package arrays_and_strings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

public class StringCompressionTest {
    private StringCompression underTest;

    @Before
    public void setUp() {
        underTest = new StringCompression();
    }

    @Test
    public void compress_withRepeatedCharacters_shouldReturnCompressed() {
        assertEquals("a2b1c5a3", underTest.compress("aabcccccaaa"));
        assertEquals("a6", underTest.compress("aaaaaa"));

    }

    @Test
    public void compress_withRepeatedCharactersReturnsSameOrGreaterLength_shouldReturnOriginalString() {
        assertEquals("aabbaabbaa", underTest.compress("aabbaabbaa"));
        assertEquals("abc", underTest.compress("abc"));
    }

    @Test
    public void compress_withEmptyString_shouldReturnEmptyString() {
        assertEquals("", underTest.compress(""));
    }

    @Test
    public void alphaNumberIncrementCount_withCharAndCount_shouldReturnIncrementedCount() {
        StringCompression.AlphaNumber alphaNumber = new StringCompression.AlphaNumber('a',1);
        alphaNumber.incrementCount();
        assertEquals("a2",alphaNumber.toString());
        alphaNumber.incrementCount();
        assertEquals("a3",alphaNumber.toString());
    }

    @Test
    public void alphaNumberIsEqualChar_withSameChar_shouldReturnTrue() {
        StringCompression.AlphaNumber alphaNumber = new StringCompression.AlphaNumber('a',1);
        assertTrue(alphaNumber.isEqualChar('a'));
    }


    @Test
    public void alphaNumberIsEqualChar_withDifferentChar_shouldReturnFalse() {
        StringCompression.AlphaNumber alphaNumber = new StringCompression.AlphaNumber('a',1);
        assertFalse(alphaNumber.isEqualChar('b'));
    }
}