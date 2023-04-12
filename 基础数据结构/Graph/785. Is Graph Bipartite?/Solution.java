// dfs, TC = O(V+E), SC = O(V)
class Solution {
  public boolean isBipartite(int[][] graph) {
    int[] colors = new int[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (colors[i] == 0) {
        if (!validColor(graph, colors, 1, i))
          return false;
      }
    }
    return true;
  }

  private boolean validColor(int[][] graph, int[] colors, int c, int node) {
    if (colors[node] != 0)
      return colors[node] == c;
    colors[node] = c;
    for (int nextNode : graph[node]) {
      if (!validColor(graph, colors, -c, nextNode))
        return false;
    }
    return true;
  }
}