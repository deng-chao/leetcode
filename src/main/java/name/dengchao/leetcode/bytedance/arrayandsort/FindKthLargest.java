package name.dengchao.leetcode.bytedance.arrayandsort;

import java.util.Arrays;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        qSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length - k];
    }

    public static void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                //  ++i;
                break;
            }
        }
        qSort(arr, head, i - 1);
        qSort(arr, i + 1, tail);
    }

    public static void main(String[] args) {
        FindKthLargest test = new FindKthLargest();
        System.out.println(test.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));

        int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        qSort(arr, 0, arr.length - 1);
        String out = "";
        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println(out);
    }
}
