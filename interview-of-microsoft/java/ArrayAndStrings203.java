/**
 * https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/203/
 * Created by hzlizx on 2019/4/2
 */
public class ArrayAndStrings203 {

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        Integer[][] help = new Integer[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    make_n1(help, j, i);
                } else if (help[i][j] == null) {
                    help[i][j] = matrix[i][j];
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = help[i][j];
            }
        }
    }

    private void make_n1(Integer[][] matrix, int x, int y) {
        if (matrix.length != 0 && matrix[0].length != 0) {
            int height = matrix.length;
            int width = matrix[0].length;
            for (int i = 0; i < height; i++) {
                matrix[i][x] = 0;
            }
            for (int i = 0; i < width; i++) {
                matrix[y][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] ma = {
                {1, 1, 1}, {1, 0, 1}, {1, 1, 1}
        };
        int[][] ma1 = {
                {0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}
        };
        ArrayAndStrings203 arrayAndStrings203 = new ArrayAndStrings203();
        arrayAndStrings203.setZeroes(ma1);
        for (int i = 0; i < ma1.length; i++) {
            for (int j = 0; j < ma1[0].length; j++) {
                System.out.print(ma1[i][j] + " ");
            }
            System.out.println();
        }
    }
}
