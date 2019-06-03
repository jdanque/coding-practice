package arrays_and_strings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class PalindromePermutationTest {
    private PalindromePermutation underTest;

    @Before
    public void setUp() {
        underTest = new PalindromePermutation();
    }

    @Test
    public void test_withPalindrome_shouldReturnTrue() {
        assertTrue(underTest.isPalindromePermutation("tact coa"));
        assertTrue(underTest.isPalindromePermutation("ggoodd"));
    }

    @Test
    public void test_withNotPalindrome_shouldReturnFalse() {
        assertFalse(underTest.isPalindromePermutation("abc cbc"));
        assertFalse(underTest.isPalindromePermutation("ccedce"));

    }

    @Test
    public void test_withEmptyString_shouldReturnTrue() {
        assertTrue(underTest.isPalindromePermutation(""));
    }
}