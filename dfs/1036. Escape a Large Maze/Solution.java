// class Solution {
//     private int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

//     public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
//         if (blocked.length == 0) return true;

//         Set<String> blockedSet = new HashSet<>();
//         for (int[] b : blocked) {
//             blockedSet.add(b[0] + "#" + b[1]);
//         }

//         return bfs(blockedSet, source, target) && bfs(blockedSet, target, source);
//     }

//     private boolean bfs(Set<String> blockedSet, int[] source, int[] target) {
//         Queue<int[]> queue = new LinkedList<>();
//         Set<String> visited = new HashSet<>();

//         queue.add(source);
//         visited.add(source[0] + "#" + source[1]);

//         while (!queue.isEmpty()) {
//             int[] cur = queue.poll();

//             if (cur[0] == target[0] && cur[1] == target[1]) {
//                 return true;
//             }

//             if (Math.abs(cur[0] - source[0]) + Math.abs(cur[1] - source[1]) > 200) {
//                 return true;
//             }

//             for (int[] dir : dirs) {
//                 int x = cur[0] + dir[0];
//                 int y = cur[1] + dir[1];
//                 String next = x + "#" + y;

//                 if (x >= 0 && x < 1000000 && y >= 0 && y < 1000000 && !blockedSet.contains(next) && !visited.contains(next)) {
//                     queue.add(new int[]{x, y});
//                     visited.add(next);
//                 }
//             }
//         }

//         return false;
//     }
// }

class Solution {
  private int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
    if (blocked.length == 0)
      return true;
    Set<String> blockedSet = new HashSet<>();
    for (int[] b : blocked)
      blockedSet.add(b[0] + "#" + b[1]);

    return dfs(blockedSet, source, target, source, new HashSet<>())
        && dfs(blockedSet, target, source, target, new HashSet<>());

  }

  private boolean dfs(Set<String> blockedSet, int[] source, int[] target, int[] cur, Set<String> visited) {
    if (cur[0] == target[0] && cur[1] == target[1])
      return true;
    if (Math.abs(cur[0] - source[0]) + Math.abs(cur[1] - source[1]) > 200)
      return true;

    visited.add(cur[0] + "#" + cur[1]);
    for (int[] dir : dirs) {
      int x = cur[0] + dir[0];
      int y = cur[1] + dir[1];
      String next = x + "#" + y;
      if (x >= 0 && x < 1000000 && y >= 0 && y < 1000000 && !blockedSet.contains(next) && !visited.contains(next)) {
        if (dfs(blockedSet, source, target, new int[] { x, y }, visited))
          return true;
      }
    }
    return false;
  }
}
