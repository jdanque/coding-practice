package arrays_and_strings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

public class RotateMatrixTest {
    private RotateMatrix underTest;

    @Before
    public void setUp() {
        underTest = new RotateMatrix();
    }

    @Test
    public void rotateRight_withValid_shouldReturnRotatedRight() {
        //1x1
        int[][] x = new int[][]{{1}};
        int[][] expected = new int[][]{{1}};
        assertArrayEquals(expected[0], underTest.rotateRight(x)[0]);

        //2x2
        x = new int[][]{{1, 2}, {3, 4}};
        expected = new int[][]{{3, 1}, {4, 2}};
        x = underTest.rotateRight(x);
        for (int i = 0; i < expected.length; i++) {
            int[] expect = expected[i];
            assertArrayEquals(expect, x[i]);
        }

        //3x3
        x = new int[][]{{1, 2, 3}, {4,5,6}, {7,8,9}};
        expected = new int[][]{{7,4,1}, {8,5,2}, {9,6,3}};
        x = underTest.rotateRight(x);
        for (int i = 0; i < expected.length; i++) {
            int[] expect = expected[i];
            assertArrayEquals(expect, x[i]);
        }

        //4x4
        x = new int[][]{{1, 2, 3, 4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
        expected = new int[][]{{13,9,5,1}, {14,10,6,2}, {15,11,7,3}, {16,12,8,4}};
        x = underTest.rotateRight(x);
        for (int i = 0; i < expected.length; i++) {
            int[] expect = expected[i];
            assertArrayEquals(expect, x[i]);
        }

    }


    @Test
    public void rotateLeft_withValid_shouldReturnRotatedLeft() {
         //1x1
        int[][] x = new int[][]{{1}};
        int[][] expected = new int[][]{{1}};
        assertArrayEquals(expected[0], underTest.rotateLeft(x)[0]);

        //2x2
        x = new int[][]{{1, 2}, {3, 4}};
        expected = new int[][]{{2, 4}, {1, 3}};
        x = underTest.rotateLeft(x);
        for (int i = 0; i < expected.length; i++) {
            int[] expect = expected[i];
            assertArrayEquals(expect, x[i]);
        }

        //3x3
        x = new int[][]{{1, 2, 3}, {4,5,6}, {7,8,9}};
        expected = new int[][]{{3,6,9}, {2,5,8}, {1,4,7}};
        x = underTest.rotateLeft(x);
        for (int i = 0; i < expected.length; i++) {
            int[] expect = expected[i];
            assertArrayEquals(expect, x[i]);
        }

        //4x4
        x = new int[][]{{1, 2, 3, 4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
        expected = new int[][]{{4,8,12,16}, {3,7,11,15}, {2,6,10,14}, {1,5,9,13}};
        x = underTest.rotateLeft(x);
        for (int i = 0; i < expected.length; i++) {
            int[] expect = expected[i];
            assertArrayEquals(expect, x[i]);
        }
    }


}