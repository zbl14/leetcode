class Solution {
  public int slidingPuzzle(int[][] board) {
    String target = "123450";
    String start = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        start += board[i][j];
      }
    }

    int[][] dirs = new int[][] { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
    Set<String> visited = new HashSet<>();
    Queue<String> q = new LinkedList<>();
    visited.add(start);
    q.offer(start);
    int res = 0;

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        String cur = q.poll();
        if (cur.equals(target))
          return res;
        int zeroIdx = cur.indexOf('0');
        for (int dir : dirs[zeroIdx]) {
          StringBuilder next = new StringBuilder(cur);
          next.setCharAt(dir, cur.charAt(zeroIdx));
          next.setCharAt(zeroIdx, cur.charAt(dir));
          String nextState = next.toString();

          if (visited.contains(nextState))
            continue;
          visited.add(nextState);
          q.offer(nextState);
        }
      }
      res++;
    }
    return -1;
  }
}