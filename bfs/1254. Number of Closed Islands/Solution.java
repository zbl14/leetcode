import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
  private int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  public int closedIsland(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    Set<String> visited = new HashSet<>();
    int cnt = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0 && !visited.contains(i + "#" + j) && bfs(grid, i, j, m, n, visited)) {
          cnt++;
        }
      }
    }
    return cnt;
  }

  private boolean bfs(int[][] grid, int x, int y, int m, int n, Set<String> visited) {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] { x, y });
    visited.add(x + "#" + y);
    boolean isClosed = true;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      for (int[] d : dirs) {
        int r = cur[0] + d[0];
        int c = cur[1] + d[1];
        if (r < 0 || r >= m || c < 0 || c >= n) {
          isClosed = false;
        } else if (grid[r][c] == 0 && !visited.contains(r + "#" + c)) {
          q.offer(new int[] { r, c });
          visited.add(r + "#" + c);
        }
      }
    }
    return isClosed;
  }
}