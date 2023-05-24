class Solution {
  public int minScore(int n, int[][] roads) {
    if (n == 2)
      return roads[0][2];
    Map<Integer, List<List<Integer>>> adj = new HashMap<>();
    for (int[] road : roads) {
      int a = road[0];
      int b = road[1];
      int c = road[2];
      adj.computeIfAbsent(a, k -> new ArrayList<List<Integer>>()).add(Arrays.asList(b, c));
      adj.computeIfAbsent(b, k -> new ArrayList<List<Integer>>()).add(Arrays.asList(a, c));
    }

    boolean[] visited = new boolean[n + 1];
    Queue<Integer> q = new LinkedList<>();
    int res = Integer.MAX_VALUE;

    q.offer(1);
    visited[1] = true;
    while (!q.isEmpty()) {
      int cur = q.poll();
      if (!adj.containsKey(cur))
        continue;
      for (List<Integer> edge : adj.get(cur)) {
        res = Math.min(res, edge.get(1));
        if (!visited[edge.get(0)]) {
          visited[edge.get(0)] = true;
          q.offer(edge.get(0));
        }
      }
    }
    return res;
  }
}