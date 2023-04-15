class Solution {
  int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    if (color == image[sr][sc])
      return image;
    int originalColor = image[sr][sc];
    Set<String> visited = new HashSet<>();
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] { sr, sc });
    visited.add(sr + "#" + sc);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int[] cur = q.poll();
        image[cur[0]][cur[1]] = color;
        for (int[] d : dirs) {
          int x = cur[0] + d[0];
          int y = cur[1] + d[1];
          String next = x + "#" + y;
          if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && !visited.contains(next)
              && image[x][y] == originalColor) {
            visited.add(next);
            q.offer(new int[] { x, y });
          }
        }
      }
    }
    return image;
  }
}