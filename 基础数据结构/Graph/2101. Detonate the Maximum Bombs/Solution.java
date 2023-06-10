class Solution {
  public int maximumDetonation(int[][] bombs) {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    for (int i = 0; i < bombs.length; i++) {
      for (int j = 0; j < bombs.length; j++) {
        if (i != j && ((bombs[j][0] - bombs[i][0]) * (bombs[j][0] - bombs[i][0])
            + (bombs[j][1] - bombs[i][1]) * (bombs[j][1] - bombs[i][1]) <= bombs[i][2] * bombs[i][2])) {
          adj.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
        }
      }
    }

    int res = 0;
    for (int i = 0; i < bombs.length; i++) {
      int cnt = dfs(i, new HashSet<>(), adj);
      res = Math.max(res, cnt);
    }
    return res;
  }

  private int dfs(int cur, Set<Integer> visited, Map<Integer, List<Integer>> adj) {
    visited.add(cur);
    int cnt = 1;
    for (int nei : adj.getOrDefault(cur, new ArrayList<>())) {
      if (!visited.contains(nei)) {
        cnt += dfs(nei, visited, adj);
      }
    }
    return cnt;
  }
}
