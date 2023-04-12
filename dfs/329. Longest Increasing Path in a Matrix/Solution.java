// dfs, TC = O(2^(m+n)), SC = O(mn), TLE
class Solution {
  private int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix.length == 0)
      return 0;

    int rows = matrix.length;
    int cols = matrix[0].length;
    int ans = 0;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        ans = Math.max(ans, dfs(matrix, r, c, rows, cols));
      }
    }
    return ans;
  }

  private int dfs(int[][] matrix, int r, int c, int rows, int cols) {
    int ans = 0;
    for (int[] dir : dirs) {
      int x = r + dir[0];
      int y = c + dir[1];
      if (x >= 0 && x < rows && y >= 0 && y < cols && matrix[x][y] > matrix[r][c]) {
        ans = Math.max(ans, dfs(matrix, x, y, rows, cols));
      }
    }
    ans++;
    return ans;
  }
}

// dfs + memorization, TC = O(mn), SC = O(mn)
class Solution {
  private int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix.length == 0)
      return 0;

    int rows = matrix.length;
    int cols = matrix[0].length;
    int ans = 0;
    int[][] memo = new int[rows][cols];
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        ans = Math.max(ans, dfs(matrix, r, c, rows, cols, memo));
      }
    }
    return ans;
  }

  private int dfs(int[][] matrix, int r, int c, int rows, int cols, int[][] memo) {
    if (memo[r][c] != 0)
      return memo[r][c];
    for (int[] dir : dirs) {
      int x = r + dir[0];
      int y = c + dir[1];
      if (x >= 0 && x < rows && y >= 0 && y < cols && matrix[x][y] > matrix[r][c]) {
        memo[r][c] = Math.max(memo[r][c], dfs(matrix, x, y, rows, cols, memo));
      }
    }
    memo[r][c]++;
    return memo[r][c];
  }
}