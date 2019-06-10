package arrays_and_strings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ZeroMatrixTest {
    private ZeroMatrix underTest;

    @Before
    public void setUp() {
        underTest = new ZeroMatrix();
    }

    @Test
    public void convert_withOneValueButNoZero_shouldReturnSame() {
        int[][] x = new int[][]{{1}};
        int[][] expected = new int[][]{{1}};
        x = underTest.convert(x);
        check2dArray(x,expected);
    }

    @Test
    public void convert_withOneValueAllZero_shouldReturnAllZero() {
        int[][] x = new int[][]{{0}};
        int[][] expected = new int[][]{{0}};
        x = underTest.convert(x);
        check2dArray(x,expected);
    }

    @Test
    public void convert_withAllZero_shouldReturnAllZero() {
        int[][] x = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
        int[][] expected = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
        x = underTest.convert(x);
        check2dArray(x,expected);
    }

    @Test
    public void convert_withOneZeroRow_shouldReturnAllZero() {
        int[][] x = new int[][]{{1,2,3},{0,0,0},{4,5,6}};
        int[][] expected = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
        x = underTest.convert(x);
        check2dArray(x,expected);
    }

    @Test
    public void convert_withOneZeroColumn_shouldReturnAllZero() {
        int[][] x = new int[][]{{0,2,3},{0,1,2},{0,5,6}};
        int[][] expected = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
        x = underTest.convert(x);
        check2dArray(x,expected);
    }

    @Test
    public void convert_withNoZeroes_shouldReturnSame() {
        int[][] x = new int[][]{{1,2,3},{7,8,9},{4,5,6}};
        int[][] expected = new int[][]{{1,2,3},{7,8,9},{4,5,6}};
        x = underTest.convert(x);
        check2dArray(x,expected);
    }

    @Test
    public void convert_withOneZero_shouldReturnConverted() {
        int[][] x = new int[][]{{1,2,3},{4,0,6},{7,8,9}};
        int[][] expected = new int[][]{{1,0,3},{0,0,0},{7,0,9}};
        x = underTest.convert(x);
        check2dArray(x,expected);

        x = new int[][]{{1,2,3},{0,5,6},{7,8,9}};
        expected = new int[][]{{0,2,3},{0,0,0},{0,8,9}};
        x = underTest.convert(x);
        check2dArray(x,expected);

        x = new int[][]{{1,2,3},{4,5,0},{7,8,9}};
        expected = new int[][]{{1,2,0},{0,0,0},{7,8,0}};
        x = underTest.convert(x);
        check2dArray(x,expected);

        x = new int[][]{{0,2,3},{4,5,6},{7,8,9}};
        expected = new int[][]{{0,0,0},{0,5,6},{0,8,9}};
        x = underTest.convert(x);
        check2dArray(x,expected);

        x = new int[][]{{1,2,3},{4,5,6},{7,8,0}};
        expected = new int[][]{{1,2,0},{4,5,0},{0,0,0}};
        x = underTest.convert(x);
        check2dArray(x,expected);
    }

    @Test
    public void convert_withTwoZero_shouldReturnConverted() {
        int[][] x = new int[][]{{1, 2, 3}, {0, 5, 0}, {7, 8, 9}};
        int[][] expected = new int[][]{{0, 2, 0}, {0,0,0}, {0, 8, 0}};
        x = underTest.convert(x);
        check2dArray(x, expected);
    }

    private void check2dArray(int[][] result, int[][] expected){
        for (int i = 0; i < expected.length; i++) {
            int[] expect = expected[i];
            assertArrayEquals(expect, result[i]);
        }
    }
}