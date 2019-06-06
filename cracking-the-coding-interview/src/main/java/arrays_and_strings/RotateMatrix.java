package arrays_and_strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Chapter 9: Interview Questions
 * Topic: Arrays and Strings
 * Problem:
 * Given an image represented by an NxN matrix,
 * where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 *
 * Notes: since it's not clear whether to implement a rotate to right or left 90deg
 * I'll do both. And it's not clear what the 4bytes is, but for this exercise
 * I'll just go with a 2d int array. (32bit = 4bytes),
 * and also, I assume that the input image has an equal length and width.
 */
public class RotateMatrix {

    enum Direction{
        LEFT, RIGHT
    }

    private int[][] rotate(int[][] image, Direction direction){
        Map<String,Integer> pointMap = new HashMap<>();

        for(int x = 0, a = image.length-1; x < image.length; x++, a--){
            for(int y = 0, b = image.length-1; y < image[x].length; y++, b--){
                int row = direction == Direction.LEFT ? b : y;
                int col = direction == Direction.LEFT ? x : a;
                pointMap.put(row+""+col,image[row][col]);
                image[row][col] = pointMap.getOrDefault(x+""+y,image[x][y]);
            }
        }

        return image;
    }

    public int[][] rotateRight(int[][] image){
        return rotate(image, Direction.RIGHT);
    }

    public int[][] rotateLeft(int[][] image){
        return rotate(image, Direction.LEFT);
    }

}
