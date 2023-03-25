class Solution {
  private int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

  public void wallsAndGates(int[][] rooms) {
    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[0].length; j++) {
        if (rooms[i][j] == 0) {
          q.offer(new int[] { i, j });
        }
      }
    }
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int row = cur[0], col = cur[1];
      for (int[] dir : dirs) {
        int newRow = row + dir[0], newCol = col + dir[1];
        if (newRow >= 0 && newRow < rooms.length && newCol >= 0 && newCol < rooms[0].length
            && rooms[newRow][newCol] == Integer.MAX_VALUE) {
          rooms[newRow][newCol] = rooms[row][col] + 1;
          q.offer(new int[] { newRow, newCol });
        }
      }
    }
  }
}
