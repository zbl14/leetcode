class Solution {
  public int[] countSubTrees(int n, int[][] edges, String labels) {
    if (n == 1)
      return new int[] { 1 };
    Map<Integer, List<Integer>> adj = new HashMap<>();
    for (int[] edge : edges) {
      int a = edge[0];
      int b = edge[1];
      adj.computeIfAbsent(a, k -> new ArrayList<Integer>()).add(b);
      adj.computeIfAbsent(b, k -> new ArrayList<Integer>()).add(a);
    }

    int[] res = new int[n];
    char[] label = labels.toCharArray();
    dfs(0, -1, adj, label, res);
    return res;
  }

  private int[] dfs(int node, int parent, Map<Integer, List<Integer>> adj, char[] label, int[] res) {
    int[] nodeCounts = new int[26];
    nodeCounts[label[node] - 'a'] = 1;

    if (!adj.containsKey(node))
      return nodeCounts;
    for (int child : adj.get(node)) {
      if (child == parent)
        continue;
      int[] childCounts = dfs(child, node, adj, label, res);
      for (int i = 0; i < 26; i++) {
        nodeCounts[i] += childCounts[i];
      }
    }
    res[node] = nodeCounts[label[node] - 'a'];
    return nodeCounts;
  }
}