package name.dengchao.leetcode.bytedance.arrayandsort;

public class FindCircleNum {

    public int findCircleNum(int[][] M) {
        if (M.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1) {
                    dfs(M, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int[][] M, int x, int y) {
        int length = M.length;
        for (int i = 0; i < length; i++) {
            if (M[x][i] == 1) {
                M[x][i] = 0;
                dfs(M, i, y);
            }
            if (M[i][y] == 1) {
                M[i][y] = 0;
                dfs(M, x, i);
            }
        }
    }
}
