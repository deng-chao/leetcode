package name.dengchao.leetcode.bytedance.arrayandsort;

public class LengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int m = 0, n = 1, l = nums.length, maxLength = 0;
        while (m < l && n < l) {
            System.out.println("m: " + m + ", n: " + n);
            if (nums[n] > nums[n - 1]) n++;
            else {
                maxLength = Math.max(maxLength, n - m);
                m = n;
                n++;
            }
        }
        return Math.max(maxLength, n - m);
    }

    public static void main(String[] args) {
        LengthOfLCIS test = new LengthOfLCIS();
        System.out.println(test.findLengthOfLCIS(new int[]{4, 3}));
    }
}
