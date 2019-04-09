/**
 * https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/202/
 * Created by hzlizx on 2019/4/2
 */
public class ArrayAndStrings202 {

    public void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int i = 0, j = 0;
        for (int length = matrix.length; length > 0; length -= 2) {
            rotateCircle(matrix, i++, j++, length);
        }
    }


    private void rotateCircle(int[][] matrix, int y1, int x1, int length) {
        int endx = x1 + length - 1;
        int endy = y1 + length - 1;
        for (int j = x1; j < endx; j++) {
            swap(matrix, y1, j, j, endx);
            swap(matrix, y1, j, endy, endx - (j - x1));
            swap(matrix, y1, j, endy - (j - y1), x1);
        }
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    public static void main(String[] args) {

        int[][] ma = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        new ArrayAndStrings202().rotate(ma);
    }
}
