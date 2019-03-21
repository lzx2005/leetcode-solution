/**
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * 示例 1:
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * Created by hzlizx on 2019/3/21
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {
                    if (i != j && k != j && isTriangle(nums[i], nums[j], nums[k])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isTriangle(int a, int b, int c) {
        return (c < a + b) && (b < a + c) && (a < c + b);
    }

    public static void main(String[] args) {
        int[] a = {2,2,3,4};
        int i = new ValidTriangleNumber().triangleNumber(a);

        System.out.println(i);
    }
}
