/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * Created by hzlizx on 2019/4/2
 */
public class BeforeYouStart1109 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0 || nums2.length == 0) {
            return;
        }
        int[] help = new int[nums1.length];
        int index = 0;
        int i = 0, j = 0;
        while (i < m && j < n) {
            int x = nums1[i];
            int y = nums2[j];
            if (x < y) {
                help[index++] = x;
                i++;
            } else {
                help[index++] = y;
                j++;
            }
        }
        while (i < m) {
            help[index++] = nums1[i++];
        }
        while (j < n) {
            help[index++] = nums2[j++];
        }
        for (int k = 0; k < help.length; k++) {
            nums1[k] = help[k];
        }
    }

    public static void main(String[] args) {
        int[] n1 = {4, 5, 6, 0, 0, 0};
        int[] n2 = {1, 2, 3};
        new BeforeYouStart1109().merge(n1, 3, n2, 3);
        for (int i : n1) {
            System.out.print(i + " ");
        }
    }
}
