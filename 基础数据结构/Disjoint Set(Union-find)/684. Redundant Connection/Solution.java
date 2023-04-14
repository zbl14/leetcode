class Solution {
  public int[] findRedundantConnection(int[][] edges) {
    if (edges == null)
      return new int[] { -1, -1 };
    DSU dsu = new DSU(edges.length + 1);
    for (int[] edge : edges) {
      if (dsu.find(edge[0]) == dsu.find(edge[1]))
        return edge;
      dsu.union(edge[0], edge[1]);
    }
    return new int[] { -1, -1 };
  }
}

class DSU {
  private int[] parent;

  public DSU(int N) {
    parent = new int[N];
    for (int i = 0; i < N; i++) {
      parent[i] = i;
    }
  }

  public int find(int x) {
    if (parent[x] != x)
      parent[x] = find(parent[x]);
    return parent[x];
  }

  public void union(int x, int y) {
    parent[find(x)] = find(y);
  }
}