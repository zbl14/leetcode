class Solution {
  int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public int numEnclaves(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      if (grid[i][0] == 1 && !visited[i][0]) {
        bfs(i, 0, m, n, grid, visited);
      }
      if (grid[i][n - 1] == 1 && !visited[i][n - 1]) {
        bfs(i, n - 1, m, n, grid, visited);
      }
    }

    for (int i = 0; i < n; i++) {
      if (grid[0][i] == 1 && !visited[0][i]) {
        bfs(0, i, m, n, grid, visited);
      }
      if (grid[m - 1][i] == 1 && !visited[m - 1][i]) {
        bfs(m - 1, i, m, n, grid, visited);
      }
    }

    int cnt = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          cnt++;
        }
      }
    }
    return cnt;
  }

  private void bfs(int x, int y, int m, int n, int[][] grid, boolean[][] visited) {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] { x, y });
    visited[x][y] = true;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      for (int[] d : dirs) {
        int r = cur[0] + d[0];
        int c = cur[1] + d[1];
        if (r < 0 || r >= m || c < 0 || c >= n)
          continue;
        else if (grid[r][c] == 1 && !visited[r][c]) {
          q.offer(new int[] { r, c });
          visited[r][c] = true;
        }
      }
    }
  }
}