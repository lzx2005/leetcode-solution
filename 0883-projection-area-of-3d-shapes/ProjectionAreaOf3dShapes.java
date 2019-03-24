/**
 * https://leetcode-cn.com/problems/projection-area-of-3d-shapes/
 * <p>
 * 在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。
 * <p>
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 * <p>
 * 现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。
 * <p>
 * 投影就像影子，将三维形体映射到一个二维平面上。
 * <p>
 * 在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。
 * <p>
 * 返回所有三个投影的总面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[2]]
 * 输出：5
 */
public class ProjectionAreaOf3dShapes {

    public int projectionArea(int[][] grid) {
        int count = 0;
        int length = grid.length;
        for (int i = 0; i < length; i++) {
            int yBigger = 0;
            int xBigger = 0;
            for (int j = 0; j < length; j++) {
                if (grid[i][j] > 0) {
                    count++;
                }
                if (grid[i][j] > xBigger) {
                    xBigger = grid[i][j];
                }
                if (grid[j][i] > yBigger) {
                    yBigger = grid[j][i];
                }
            }
            count += xBigger;
            count += yBigger;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0}, {5, 4}};
        int i = new ProjectionAreaOf3dShapes().projectionArea(grid);
        System.out.println(i);

    }

}
