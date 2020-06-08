package name.dengchao.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。<br>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。<br>
 * 示例:
 * <pre>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * </pre>
 */
public class LeetCode001 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[]{};
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            Integer other = map.get(target - nums[i]);
            if (other != null) {
                return new int[]{other, i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        LeetCode001 code001 = new LeetCode001();
        System.out.println(Arrays.toString(code001.twoSum(new int[]{3, 2, 4}, 6)));
    }
}
