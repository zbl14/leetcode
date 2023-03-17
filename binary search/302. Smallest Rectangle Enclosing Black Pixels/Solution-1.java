// 302. Smallest Rectangle Enclosing Black Pixels;
// dfs, TC = O(mn), SC = O(mn)
class Solution {
  private int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = 0, maxY = 0;
  private int[] dirs = { -1, 0, 1, 0, -1 };

  public int minArea(char[][] image, int x, int y) {
    if (image == null || image.length == 0 || image[0].length == 0)
      return 0;
    dfs(image, x, y);
    return (maxX - minX + 1) * (maxY - minY + 1);
  }

  private void dfs(char[][] image, int x, int y) {
    int m = image.length, n = image[0].length;
    if (x < 0 || y < 0 || x >= m || y >= n || image[x][y] == '0')
      return;
    image[x][y] = '0';
    minX = Math.min(minX, x);
    minY = Math.min(minY, y);
    maxX = Math.max(maxX, x);
    maxY = Math.max(maxY, y);
    for (int i = 0; i < 4; i++) {
      int newX = x + dirs[i];
      int newY = y + dirs[i + 1];
      dfs(image, newX, newY);
    }
  }
}
