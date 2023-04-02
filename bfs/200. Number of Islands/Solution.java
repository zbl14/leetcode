class Solution {
  private int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

  public int numIslands(char[][] grid) {
    int res = 0;
    if (grid == null || grid.length == 0)
      return res;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          res++;
          bfs(grid, i, j);
        }
      }
    }
    return res;
  }

  private void bfs(char[][] grid, int i, int j) {
    int m = grid.length;
    int n = grid[0].length;
    grid[i][j] = '0';
    Queue<Integer> q = new LinkedList<>();
    q.offer(i * n + j);
    while (!q.isEmpty()) {
      int cur = q.poll();
      int x = cur / n;
      int y = cur % n;
      for (int[] dir : dirs) {
        int newX = x + dir[0];
        int newY = y + dir[1];
        if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == '1') {
          grid[newX][newY] = '0';
          q.offer(newX * n + newY);
        }
        ;
      }
    }
  }
}