package arrays_and_strings;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckPermutationTest {
    private CheckPermutation underTest;

    @Before
    public void setUp() {
        underTest = new CheckPermutation();
    }

    @Test
    public void isPermutation_withSimilarStrings_shouldReturnTrue() {
        assertTrue(underTest.isPermutation("abc", "abc"));
        assertTrue(underTest.isPermutation("abc", "cba"));
    }

    @Test
    public void isPermutation_withNotSimilarStrings_shouldReturnFalse() {
        assertFalse(underTest.isPermutation("abc", "xyz"));
        assertFalse(underTest.isPermutation("888", "123"));
        assertFalse(underTest.isPermutation("dog", "God"));
    }

    @Test
    public void isPermutation_withInput1Empty_Input2Valid_shouldReturnFalse() {
        assertFalse(underTest.isPermutation("", "xyz"));
    }

    @Test
    public void isPermutation_withBothInputEmpty_shouldReturnTrue() {
        assertTrue(underTest.isPermutation("", ""));
    }


}