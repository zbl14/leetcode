class Solution {
  private int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

  public int shortestPathBinaryMatrix(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1)
      return -1;
    int[][] distance = new int[rows][cols];
    boolean[][] visited = new boolean[rows][cols];
    for (int[] row : distance)
      Arrays.fill(row, Integer.MAX_VALUE);
    distance[0][0] = 1;
    PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    q.offer(new int[] { 0, 0, 1 });
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      if (visited[cur[0]][cur[1]])
        continue;
      visited[cur[0]][cur[1]] = true;
      for (int[] dir : dirs) {
        int x = cur[0] + dir[0];
        int y = cur[1] + dir[1];
        if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] || grid[x][y] == 1)
          continue;
        int dist = distance[cur[0]][cur[1]] + 1;
        if (dist < distance[x][y]) {
          distance[x][y] = dist;
          q.offer(new int[] { x, y, dist });
        }
      }
    }
    return distance[rows - 1][cols - 1] == Integer.MAX_VALUE ? -1 : distance[rows - 1][cols - 1];
  }
}
