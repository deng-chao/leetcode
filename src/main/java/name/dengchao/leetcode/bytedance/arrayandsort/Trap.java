package name.dengchao.leetcode.bytedance.arrayandsort;

public class Trap {
    public int trap(int[] height) {
        if (height == null || height.length < 2) return 0;
        int left = 0, right = height.length - 1, area = 0, leftMax = height[left], rightMax = height[right];
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                area = area + leftMax - height[left];
                left++;
            } else {
                area = area + rightMax - height[right];
                right--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Trap trap = new Trap();
        System.out.println(trap.trap(height));
    }
}
