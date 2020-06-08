package name.dengchao.leetcode.bytedance.arrayandsort;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return results;
        }
        List<Integer> sortedList = new ArrayList<>();
        Arrays.sort(nums);
        sortedList.add(nums[0]);
        sortedList.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != sortedList.get(sortedList.size() - 2)) sortedList.add(nums[i]);
            else if (nums[i] == 0 && (sortedList.size() < 3 || nums[i] != sortedList.get(sortedList.size() - 3)))
                sortedList.add(nums[i]);
        }
        System.out.println(sortedList);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer i = map.get(num);
            i = i == null ? 0 : i + 1;
            map.put(num, i);
        }
        HashSet<List<Integer>> tmpSet = new HashSet<>();
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = i + 1; j < sortedList.size() - 0; j++) {
                int sum = -(sortedList.get(i) + sortedList.get(j));
                Integer cnt = map.get(sum);
                if (cnt != null) {
                    if ((sortedList.get(i) == sum || sortedList.get(j) == sum) && cnt < 2) continue;
                    Integer[] tmpArray = new Integer[]{sortedList.get(i), sortedList.get(j), sum};
                    Arrays.sort(tmpArray);
                    tmpSet.add(Arrays.asList(tmpArray));
                }
            }
        }
        results.addAll(tmpSet);
        return results;
    }

    public static void main(String[] args) {
        ThreeSum test = new ThreeSum();
        System.out.println(test.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
