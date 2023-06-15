// dfs + memo
class Solution {
  public int uniquePaths(int m, int n) {
    int[][] memo = new int[m + 1][n + 1];
    return dfs(0, 0, m, n, memo);
  }

  private int dfs(int i, int j, int m, int n, int[][] memo) {
    if (i >= m || j >= n) {
      return 0;
    }
    if (i == m - 1 && j == n - 1) {
      return 1;
    }

    if (memo[i][j] != 0) {
      return memo[i][j];
    }

    int x = dfs(i + 1, j, m, n, memo);
    int y = dfs(i, j + 1, m, n, memo);

    return memo[i][j] = x + y;
  }
}