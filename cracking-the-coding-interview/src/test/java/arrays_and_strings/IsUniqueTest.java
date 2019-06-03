package arrays_and_strings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsUniqueTest {
    private IsUnique underTest;

    @Before
    public void setUp() {
        underTest = new IsUnique();
    }

    @Test
    public void isUnique_withAllUnique_shouldReturnTrue() {
        assertTrue(underTest.isUnique("abcdefghijklmnopqrstuwxyz"));
    }

    @Test
    public void isUnique_withInputHasRepeating_shouldReturnFalse() {
        assertFalse(underTest.isUnique("abbbbbcdefghijklmnopqrstuwxyz"));
        assertFalse(underTest.isUnique("abcdefghijklmnopqrstuwxyzbb"));
    }

    @Test
    public void isUnique_withEmptyString_shouldReturnTrue() {
        assertTrue(underTest.isUnique(""));
    }

    @Test(expected = NullPointerException.class)
    public void isUnique_withNull_shouldThrowException() {
        underTest.isUnique(null);
    }
}