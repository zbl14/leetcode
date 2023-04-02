class Solution {
  private int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  public int orangesRotting(int[][] grid) {
    if (grid == null || grid.length == 0)
      return -1;
    int m = grid.length;
    int n = grid[0].length;
    Queue<Integer> q = new LinkedList<>();
    int fresh = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2)
          q.offer(i * n + j);
        else if (grid[i][j] == 1)
          fresh++;
      }
    }
    int min = 0;
    while (!q.isEmpty() && fresh != 0) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int cur = q.poll();
        int x = cur / n;
        int y = cur % n;
        for (int[] dir : dirs) {
          int newX = x + dir[0];
          int newY = y + dir[1];
          if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
            grid[newX][newY] = 2;
            fresh--;
            q.offer(newX * n + newY);
          }
        }
      }
      min++;
    }
    return fresh == 0 ? min : -1;
  }
}