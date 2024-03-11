import java.util.ArrayList;

public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        if (array2d == null || array2d.length == 0 || !isPerfectSquare(array2d)) {
            return new int[0];
        }
        int rows = array2d.length;
        int[] result = new int[rows * rows];
        int top = 0, bottom = rows - 1, left = 0, right = rows - 1;
        int index = 0;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result[index++] = array2d[top][i];
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result[index++] = array2d[i][right];
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[index++] = array2d[bottom][i];
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[index++] = array2d[i][left];
                }
                left++;
            }
        }
        return result;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     { 1, 2, 3, 4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if (array1d == null || array1d.length == 0) {
            return new int[0][0];
        }
        int len = (int) Math.sqrt(array1d.length);
        if (!isPerfectSquare(array1d)) {
            return new int[0][0];
        }
        int[][] result = new int[len][len];
        int index = 0;
        int left = 0, right = len - 1, top = 0, bottom = len - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result[top][i] = array1d[index++];
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result[i][right] = array1d[index++];
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = array1d[index++];
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = array1d[index++];
                }
                left++;
            }
        }

        return result;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for (int i = 0;i < array1d.length;i++){
            System.out.println(array1d[i]);
        }
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    public static void print2dArray(int[][] array2d) {
        for (int i = 0;i < array2d.length;i++){
            for (int j = 0;j < array2d[i].length;i++){
                System.out.println(array2d[i][j]);
            }
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        int len = (int) Math.sqrt(array1d.length);
        if (len * len != array1d.length) {
            return false;
        }
        return true;
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        int num = 0;
        for (int[] i: array2d){
            for (int j: i){
                num++;
            }
        }
        double i = Math.sqrt(num);
        if ((int) i * (int) i != num){
            return false;
        }
        return true;
    }


}
