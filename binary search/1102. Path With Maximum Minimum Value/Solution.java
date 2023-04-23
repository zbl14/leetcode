// binary search + bfs
// class Solution {
//     private int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//     public int maximumMinimumPath(int[][] grid) {
//         if(grid == null || grid.length == 0 || grid[0].length ==0) return -1;
//         int m = grid.length;
//         int n = grid[0].length;
//         int l = 0;
//         int r = Math.min(grid[0][0], grid[m - 1][n - 1]);
//         while(l <= r){
//             int mid = l + (r - l) / 2;
//             if(isValid(mid, grid, m, n)) {
//                 l = mid + 1;
//             } else {
//                 r = mid - 1;
//             }
//         }
//         return r;
//     }

//     private boolean isValid(int mid, int[][]grid, int rows, int cols){
//         boolean[][] visited = new boolean[rows][cols];
//         Queue<int[]> q = new LinkedList<>();
//         visited[0][0] = true;
//         q.offer(new int[]{0, 0});

//         while(!q.isEmpty()){
//             int[] cur = q.poll();
//             if(cur[0] == rows - 1 && cur[1] == cols - 1) return true;
//             for(int[] d : dirs){
//                 int x = cur[0] + d[0];
//                 int y = cur[1] + d[1];
//                 if(x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y] && grid[x][y] >= mid){
//                     visited[x][y] = true;
//                     q.offer(new int[]{x, y});
//                 }
//             }
//         }
//         return false;
//     }
// }

// bfs + pq, TC = O(m*n*log⁡(m*n))
class Solution {
  private int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public int maximumMinimumPath(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0)
      return -1;
    int m = grid.length;
    int n = grid[0].length;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> grid[b[0]][b[1]] - grid[a[0]][a[1]]);
    boolean[][] visited = new boolean[m][n];
    visited[0][0] = true;
    pq.offer(new int[] { 0, 0 });
    int res = grid[0][0];

    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      res = Math.min(res, grid[cur[0]][cur[1]]);

      if (cur[0] == m - 1 && cur[1] == n - 1)
        break;
      for (int[] d : dirs) {
        int x = cur[0] + d[0];
        int y = cur[1] + d[1];
        if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
          visited[x][y] = true;
          pq.offer(new int[] { x, y });
        }
      }
    }
    return res;
  }
}