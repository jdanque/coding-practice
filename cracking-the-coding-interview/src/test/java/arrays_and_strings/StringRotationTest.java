package arrays_and_strings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringRotationTest {
    private StringRotation underTest;

    @Before
    public void setUp() {
        underTest = new StringRotation();
    }

    @Test
    public void isSubstring_withRotated_shouldReturnTrue() {
        assertTrue(underTest.isSubstring("waterbottle","erbottlewat"));
        assertTrue(underTest.isSubstring("doggo","godog"));
    }

    @Test
    public void isSubstring_withNotRotated_shouldReturnFalse() {
        assertFalse(underTest.isSubstring("abc","def"));
        assertFalse(underTest.isSubstring("jjj","xxx"));
    }

    @Test
    public void isSubstring_withNotSameLength_shouldReturnFalse() {
        assertFalse(underTest.isSubstring("waterbottle","erbottlewa"));
        assertFalse(underTest.isSubstring("doggo","dog"));
    }

}