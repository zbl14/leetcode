class Solution {
  private int[] dirs = { -1, 0, 1, 0, -1 };

  public int numIslands(char[][] grid) {
    int res = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          res++;
          dfs(grid, i, j);
        }
      }
    }
    return res;
  }

  private void dfs(char[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
      return;
    grid[i][j] = '0';
    for (int k = 0; k < 4; k++) {
      int newI = i + dirs[k];
      int newJ = j + dirs[k + 1];
      dfs(grid, newI, newJ);
    }
  }
}