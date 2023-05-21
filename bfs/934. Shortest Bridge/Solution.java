public class Solution {
  private int[][] grid;
  private int rows, cols;
  private int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
  private Queue<int[]> queue = new LinkedList<>();

  public int shortestBridge(int[][] grid) {
    this.grid = grid;
    this.rows = grid.length;
    this.cols = grid[0].length;
    int step = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 1) {
          dfs(i, j);
          return bfs();
        }
      }
    }

    return step;
  }

  private void dfs(int r, int c) {
    if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 2)
      return;
    if (grid[r][c] == 0) {
      queue.offer(new int[] { r, c });
      return;
    }

    grid[r][c] = 2;
    queue.offer(new int[] { r, c });
    for (int[] d : dirs) {
      int newR = r + d[0];
      int newC = c + d[1];
      dfs(newR, newC);
    }
  }

  private int bfs() {
    int step = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      step++;
      for (int i = 0; i < size; i++) {
        int[] cur = queue.poll();
        for (int[] d : dirs) {
          int newI = cur[0] + d[0];
          int newJ = cur[1] + d[1];
          if (newI < 0 || newI >= rows || newJ < 0 || newJ >= cols || grid[newI][newJ] == 2) {
            continue;
          }
          if (grid[newI][newJ] == 1) {
            return step;
          }
          if (grid[newI][newJ] == 0) {
            grid[newI][newJ] = 2;
            queue.offer(new int[] { newI, newJ });
          }
        }
      }
    }
    return -1;
  }
}
