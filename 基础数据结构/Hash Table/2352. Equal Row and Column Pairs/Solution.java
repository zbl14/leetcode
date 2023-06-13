class Solution {
  public int equalPairs(int[][] grid) {
    Map<String, Integer> map = new HashMap<>();
    for (int[] row : grid) {
      String rowStr = Arrays.toString(row);
      map.put(rowStr, map.getOrDefault(rowStr, 0) + 1);
    }

    int cnt = 0;
    for (int c = 0; c < grid.length; c++) {
      int[] col = new int[grid.length];
      for (int r = 0; r < grid.length; r++) {
        col[r] = grid[r][c];
      }
      cnt += map.getOrDefault(Arrays.toString(col), 0);
    }
    return cnt;
  }
}