import java.util.LinkedList;
import java.util.Queue;

class Solution {
  private int[] dirs = { -1, 0, 1, 0, -1 };

  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    int rows = maze.length;
    int cols = maze[0].length;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] { start[0], start[1] });
    maze[start[0]][start[1]] = -1;

    while (!q.isEmpty()) {
      int cur[] = q.poll();
      if (cur[0] == destination[0] && cur[1] == destination[1])
        return true;

      for (int k = 0; k < 4; k++) {
        int i = cur[0] + dirs[k];
        int j = cur[1] + dirs[k + 1];
        while (i >= 0 && i < rows && j >= 0 && j < cols && maze[i][j] != 1) {
          i += dirs[k];
          j += dirs[k + 1];
        }
        i -= dirs[k];
        j -= dirs[k + 1];

        if (maze[i][j] != -1) {
          maze[i][j] = -1;
          q.offer(new int[] { i, j });
        }
      }
    }
    return false;
  }
}