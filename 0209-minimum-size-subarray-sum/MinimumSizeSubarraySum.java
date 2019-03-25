/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例:
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class MinimumSizeSubarraySum {
    //todo 还没完成
    public int minSubArrayLen(int s, int[] nums) {
        int p1 = 0, p2 = 0, count = 0, sum = 0, diff = 0;
        int length = nums.length;
        for (p1 = 0; p1 < length; p1++) {
            sum = 0;
            sum += nums[p1];
            count++;
            if (sum > s) {
                return 1;
            }
            int factor = nums[p1 + 1] - nums[p1];
            for (p2 = p1 + 1; p2 < length; p2++) {
                diff = nums[p2] - nums[p2 - 1];
                if (diff == factor) {

                }
            }
        }
        return 0;
    }
}
