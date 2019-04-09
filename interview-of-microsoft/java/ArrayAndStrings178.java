import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/178/
 * Created by hzlizx on 2019/4/2
 */
public class ArrayAndStrings178 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int x1 = 0, y1 = 0, y2 = matrix.length - 1, x2 = matrix[0].length - 1;
        while (x1 <= x2 && y1 <= y2) {
            circleDraw(matrix, x1++, y1++, x2--, y2--, list);
        }
        return list;
    }

    private void circleDraw(int[][] matrix, int x1, int y1, int x2, int y2, List<Integer> list) {
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) {
                list.add(matrix[i][x1]);
            }
        } else if (y1 == y2) {
            for (int i = x1; i <= x2; i++) {
                list.add(matrix[y1][i]);
            }
        } else {
            for (int i = x1; i < x2; i++) {
                list.add(matrix[y1][i]);
            }
            for (int i = y1; i < y2; i++) {
                list.add(matrix[i][x2]);
            }
            for (int i = x2; i > x1; i--) {
                list.add(matrix[y2][i]);
            }
            for (int i = y2; i > y1; i--) {
                list.add(matrix[i][x1]);
            }
        }
    }

    public static void main(String[] args) {
        //int[][] ma = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] ma = {{2, 3}};
        List<Integer> integers = new ArrayAndStrings178().spiralOrder(ma);
        integers.forEach(System.out::println);
    }
}
