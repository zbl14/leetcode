class Solution {
  public boolean possibleBipartition(int n, int[][] dislikes) {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    for (int[] dislike : dislikes) {
      adj.computeIfAbsent(dislike[0], k -> new ArrayList<Integer>()).add(dislike[1]);
      adj.computeIfAbsent(dislike[1], k -> new ArrayList<Integer>()).add(dislike[0]);
    }

    int[] color = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      if (color[i] == 0) {
        if (!bfs(i, adj, color))
          return false;
      }
    }
    return true;
  }

  private boolean bfs(int i, Map<Integer, List<Integer>> adj, int[] color) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(i);
    color[i] = 1;
    while (!q.isEmpty()) {
      int cur = q.poll();
      if (!adj.containsKey(cur))
        continue;
      for (int nei : adj.get(cur)) {
        if (color[nei] == color[cur])
          return false;
        if (color[nei] == 0) {
          color[nei] = -color[cur];
          q.offer(nei);
        }
      }
    }
    return true;
  }
}
