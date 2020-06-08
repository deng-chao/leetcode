package name.dengchao.leetcode.bytedance.arrayandsort;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int m = 0, n = nums.length - 1, x = (n - m) / 2;
        if (nums[0] > nums[nums.length - 1]) {
            if (nums[nums.length - 1] < nums[nums.length - 2]) x = nums.length - 1;
            else {
                while (!(nums[x] < nums[x + 1] && nums[x] < nums[x - 1])) {
                    if (nums[x] > nums[0]) m = x;
                    else n = x;
                    x = (n - m) / 2 + m;
                }
            }
            if (target >= nums[0] && target <= nums[x - 1]) return binSearch(nums, 0, x - 1, target);
            else return binSearch(nums, x, nums.length - 1, target);
        } else return binSearch(nums, 0, nums.length - 1, target);
    }

    private int binSearch(int[] nums, int low, int up, int target) {
        if (target < nums[low] || target > nums[up]) return -1;
        while (low < up) {
            int x = (up - low) / 2 + low;
            if (target > nums[x]) low = x + 1;
            else if (target < nums[x]) up = x - 1;
            else return x;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();
        System.out.println(test.search(new int[]{3, 1}, 0));
    }
}
