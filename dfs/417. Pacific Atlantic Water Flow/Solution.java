class Solution {
  private int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int m = heights.length;
    int n = heights[0].length;
    boolean[][] pacific = new boolean[m][n];
    boolean[][] atlantic = new boolean[m][n];

    for (int row = 0; row < m; row++) {
      dfs(row, 0, -1, pacific, heights);
      dfs(row, n - 1, -1, atlantic, heights);
    }

    for (int col = 0; col < n; col++) {
      dfs(0, col, -1, pacific, heights);
      dfs(m - 1, col, -1, atlantic, heights);
    }

    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          res.add(Arrays.asList(i, j));
        }
      }
    }
    return res;
  }

  private void dfs(int r, int c, int prev, boolean[][] ocean, int[][] heights) {
    if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || ocean[r][c] || heights[r][c] < prev)
      return;
    ocean[r][c] = true;
    for (int[] d : dirs) {
      int x = r + d[0];
      int y = c + d[1];
      dfs(x, y, heights[r][c], ocean, heights);
    }
  }
}