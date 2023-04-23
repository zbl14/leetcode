// bfs
// class Solution {
//   private int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
//   public int minArea(char[][] image, int x, int y) {
//       if (image == null || image.length == 0 || image[0].length == 0) return 0;
//       int xMin = image.length;
//       int yMin = image[0].length;
//       int xMax = 0;
//       int yMax = 0;

//       Set<String> visited = new HashSet<>();
//       Queue<int[]> q = new LinkedList<>();
//       q.offer(new int[]{x, y});
//       visited.add(x + "," + y);
//       while(!q.isEmpty()){
//           int[] cur = q.poll();
//           xMin = Math.min(xMin, cur[0]);
//           xMax = Math.max(xMax, cur[0]);
//           yMin = Math.min(yMin, cur[1]);
//           yMax = Math.max(yMax, cur[1]);
//           for(int[] d : dirs){
//               int i = cur[0] + d[0];
//               int j = cur[1] + d[1];
//               if(i >= 0 && i < image.length && j >= 0 && j < image[0].length && image[i][j] == '1' && !visited.contains(i + "," + j)) {
//                   visited.add(i + "," + j);
//                   q.offer(new int[]{i, j});
//               }
//           }
//       }
//       return (xMax - xMin + 1) * (yMax - yMin +1);
//   }
// }

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
