class Solution {
  private long fuel;

  public long minimumFuelCost(int[][] roads, int seats) {
    if (roads.length == 0)
      return 0;
    Map<Integer, List<Integer>> adj = new HashMap<>();
    for (int[] road : roads) {
      int a = road[0];
      int b = road[1];
      adj.computeIfAbsent(a, k -> new ArrayList<Integer>()).add(b);
      adj.computeIfAbsent(b, k -> new ArrayList<Integer>()).add(a);
    }
    dfs(0, -1, adj, seats);
    return fuel;
  }

  private long dfs(int node, int parent, Map<Integer, List<Integer>> adj, int seats) {
    int reps = 1;
    if (!adj.containsKey(node))
      return reps;
    for (int child : adj.get(node)) {
      if (child == parent)
        continue;
      reps += dfs(child, node, adj, seats);
    }
    if (node != 0) {
      fuel += Math.ceil((double) reps / seats);
    }
    return reps;
  }
}