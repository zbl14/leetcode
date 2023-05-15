// TC = O(mn), SC = (1)
// class Solution {
//     public int islandPerimeter(int[][] grid) {
//         int rows = grid.length;
//         int cols = grid[0].length;

//         int result = 0;
//         for (int r = 0; r < rows; r++) {
//             for (int c = 0; c < cols; c++) {
//                 if (grid[r][c] == 1) {
//                     result += 4;

//                     if (r > 0 && grid[r-1][c] == 1) {
//                         result -= 2;
//                     }

//                     if (c > 0 && grid[r][c-1] == 1) {
//                         result -= 2;
//                     }
//                 }
//             }
//         }

//         return result;
//     }
// }

// bfs, TC = O(mn), SC = (mn)
class Solution {
  private int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public int islandPerimeter(int[][] grid) {
    if (grid == null || grid.length == 0)
      return 0;

    Queue<int[]> q = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    boolean found = false;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          q.offer(new int[] { i, j });
          visited.add(i + "#" + j);
          break;
        }
      }
    }

    int cnt = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int[] cur = q.poll();
        for (int[] d : dirs) {
          int x = cur[0] + d[0];
          int y = cur[1] + d[1];
          if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            cnt++;
          } else if (!visited.contains(x + "#" + y)) {
            visited.add(x + "#" + y);
            q.offer(new int[] { x, y });
          }
        }
      }
    }
    return cnt;
  }
}
