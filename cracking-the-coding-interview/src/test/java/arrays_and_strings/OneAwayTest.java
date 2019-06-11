package arrays_and_strings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OneAwayTest {
    private OneAway underTest;

    @Before
    public void setUp() {
        underTest = new OneAway();
    }

    @Test
    public void isOneAway_withSameStrings_shouldReturnTrue() {
        assertTrue(underTest.isOneAway("pale","pale"));
        assertTrue(underTest.isOneAway("abc","abc"));
        assertTrue(underTest.isOneAway("xyz","xyz"));
    }

    @Test
    public void isOneAway_withOneInputIsLessLengthBy1_shouldReturnTrue() {
        assertTrue(underTest.isOneAway("pale","ple"));
        assertTrue(underTest.isOneAway("pales","pale"));
        assertTrue(underTest.isOneAway("abc","ab"));
        assertTrue(underTest.isOneAway("xy","xyz"));
    }

    @Test
    public void isOneAway_withOneDiffCharacterSameLength_shouldReturnTrue() {
        assertTrue(underTest.isOneAway("abd","abc"));
        assertTrue(underTest.isOneAway("pale","bale"));
        assertTrue(underTest.isOneAway("xyz","xdz"));
    }

    @Test
    public void isOneAway_withOneInputMoreLengthBy1_shouldReturnTrue() {
        assertTrue(underTest.isOneAway("babc","abc"));
        assertTrue(underTest.isOneAway("xyz","wxyz"));
    }

    @Test
    public void isOneAway_withMoreThanOneDifference_shouldReturnFalse() {
        assertFalse(underTest.isOneAway("cbabc","abc"));
        assertFalse(underTest.isOneAway("xyz","wxyzx"));
        assertFalse(underTest.isOneAway("abc","def"));
        assertFalse(underTest.isOneAway("a","bcd"));
        assertFalse(underTest.isOneAway("xxx","zzx"));
    }
}