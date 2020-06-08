package name.dengchao.leetcode.bytedance.arrayandsort;

import java.util.HashSet;

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashSet set = new HashSet(nums.length);
        for (int num : nums) set.add(num);
        int longest = 0;
        for (int num : nums) {
            int up = num + 1, length = 1;
            while (set.contains(up)) {
                length++;
                set.remove(up++);
            }
            int down = num - 1;
            while (set.contains(down)) {
                length++;
                set.remove(down--);
            }
            set.remove(num);
            longest = Math.max(longest, length);
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestConsecutive test = new LongestConsecutive();
        System.out.println(test.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
