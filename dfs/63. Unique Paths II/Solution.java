class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] memo = new int[m][n];

    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }

    return dfs(0, 0, obstacleGrid, memo);
  }

  private int dfs(int i, int j, int[][] obstacleGrid, int[][] memo) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;

    if (i >= m || j >= n || obstacleGrid[i][j] == 1) {
      return 0;
    }

    if (i == m - 1 && j == n - 1) {
      return 1;
    }

    if (memo[i][j] != -1) {
      return memo[i][j];
    }

    int right = dfs(i + 1, j, obstacleGrid, memo);
    int down = dfs(i, j + 1, obstacleGrid, memo);

    return memo[i][j] = right + down;
  }
}
