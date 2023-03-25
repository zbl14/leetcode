// dijkstra和bfs都是解决图最短路径的方法，dijkstra用于有权重的图，
// 将BFS中使用的队列数据结构替换成了优先队列
// TC = O(N^2logN), dijkstra has a TC of O(ElogV)
// SC = O(N^2), because of the `distance` array
class Solution {
  private int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public int shortestDistance(int[][] maze, int[] start, int[] destination) {
    int rows = maze.length;
    int cols = maze[0].length;
    int[][] distance = new int[rows][cols];
    for (int[] row : distance)
      Arrays.fill(row, Integer.MAX_VALUE);
    distance[start[0]][start[1]] = 0;
    dijkstra(maze, start, distance);
    return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1
        : distance[destination[0]][destination[1]];
  }

  private void dijkstra(int[][] maze, int[] start, int[][] distance) {
    PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    q.offer(new int[] { start[0], start[1], 0 });
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      for (int[] dir : dirs) {
        int x = cur[0] + dir[0];
        int y = cur[1] + dir[1];
        int count = 0;
        while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
          x += dir[0];
          y += dir[1];
          count++;
        }
        x -= dir[0];
        y -= dir[1];
        if (distance[cur[0]][cur[1]] + count < distance[x][y]) {
          distance[x][y] = distance[cur[0]][cur[1]] + count;
          q.offer(new int[] { x, y, distance[x][y] });
        }
      }
    }
  }
}