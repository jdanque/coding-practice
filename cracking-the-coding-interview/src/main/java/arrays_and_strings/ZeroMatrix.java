package arrays_and_strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Chapter 9: Interview Questions
 * Topic: Arrays and Strings
 * Problem:
 * Write an algorithm such that if an element is an MxN matrix is 0,
 * its entire row and column are set to 0.
 */
public class ZeroMatrix {

    public int[][] convert(int[][] matrix){

        List<Integer> rowsToExplode = new ArrayList<>();
        List<Integer> colsToExplode = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 0){
                    rowsToExplode.add(row);
                    colsToExplode.add(col);
                }
            }
        }

        for (Integer row : rowsToExplode) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[row][i] = 0;
            }
        }

        for (Integer col : colsToExplode) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }

        return matrix;
    }

}
