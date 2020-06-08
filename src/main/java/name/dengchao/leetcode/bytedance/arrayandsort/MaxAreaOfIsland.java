package name.dengchao.leetcode.bytedance.arrayandsort;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            int length = grid[i].length;
            for (int j = 0; j < length; j++) {
                result = Math.max(result, countLand(grid, i, j));
            }
        }
        return result;
    }

    private int countLand(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + countLand(grid, i - 1, j) + countLand(grid, i, j - 1) + countLand(grid, i + 1, j) + countLand(grid, i, j + 1);
        } else {
            return 0;
        }
    }
}
