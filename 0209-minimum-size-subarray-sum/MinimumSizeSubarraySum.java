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

    //todo 还没做完

    public static void main(String[] args) {
        int[] arr = {12,28,83,4,25,26,25,2,25,25,25,12};
        int i = new MinimumSizeSubarraySum().minSubArrayLen(213, arr);
        System.out.println(i);
    }


    public int minSubArrayLen(int s, int[] nums) {
        int p1 = 0, p2 = 0;
        for (int num : nums) {
            if (num >= s) {
                return 1;
            }
        }
        while (p1 < nums.length && p2 < nums.length) {
            if (isSorted(nums, p1, p2)) {
                if (sum(nums, p1, p2) >= s) {
                    int pp1 = p1;
                    while (pp1 <= p2) {
                        if (sum(nums, pp1, p2) >= s) {
                            pp1 += 1;
                        } else {
                            break;
                        }
                    }
                    pp1 -= 1;
                    return (p2 - pp1) + 1;
                } else {
                    p2++;
                }
            } else {
                p1++;
            }
        }
        return 0;
    }

    private boolean isSorted(int[] array, int begin, int end) {
        int length = end - begin;
        if (length == 0 || length == 1) {
            return true;
        }
        int diff = array[begin + 1] - array[begin]; // every array[p2] - array[p1] should equals diff
        if (diff != 1 && diff != -1) {
            return false;
        }
        for (int i = begin; i < end; i++) {
            if (array[i + 1] - array[i] != diff) {
                return false;
            }
        }
        return true;
    }

    private int sum(int[] array, int begin, int end) {
        int sum = 0;
        for (int i = begin; i <= end; i++) {
            sum += array[i];
        }
        return sum;
    }
}
