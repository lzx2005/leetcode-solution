import java.util.HashMap;

/**
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * Created by hzlizx on 2019/3/21
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int needNum = target - nums[i];
            if (map.containsKey(needNum)) {
                return new int[]{map.get(needNum), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
