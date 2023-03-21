import java.util.LinkedList;
import java.util.Queue;

// TC = O(mn), SC = O(mn)
class Solution {
  private int[] dirs = { -1, 0, 1, 0, -1 };

  public int[][] updateMatrix(int[][] mat) {
    int rows = mat.length;
    int cols = mat[0].length;
    int res[][] = new int[rows][cols];
    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (mat[i][j] == 0) {
          q.offer(new int[] { i, j });
          res[i][j] = 0;
        } else {
          res[i][j] = -1;
        }
      }
    }

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      for (int k = 0; k < 4; k++) {
        if (isValid(res, cur[0] + dirs[k], cur[1] + dirs[k + 1])) {
          q.offer(new int[] { cur[0] + dirs[k], cur[1] + dirs[k + 1] });
          res[cur[0] + dirs[k]][cur[1] + dirs[k + 1]] = res[cur[0]][cur[1]] + 1;
        }
      }
    }
    return res;
  }

  private boolean isValid(int[][] res, int i, int j) {
    if (i < 0 || i >= res.length || j < 0 || j >= res[0].length)
      return false;
    if (res[i][j] != -1)
      return false;
    return true;
  }
}