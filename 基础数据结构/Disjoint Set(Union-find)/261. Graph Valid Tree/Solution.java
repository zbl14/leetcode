class Solution {
  public boolean validTree(int n, int[][] edges) {
    if (edges.length != n - 1)
      return false;

    DSU dsu = new DSU(n);
    for (int[] edge : edges) {
      if (!dsu.union(edge[0], edge[1]))
        return false;
    }
    return true;
  }
}

class DSU {
  int[] parent;

  public DSU(int N) {
    parent = new int[N];
    for (int i = 0; i < N; i++)
      parent[i] = i;
  }

  public int find(int x) {
    if (parent[x] != x)
      parent[x] = find(parent[x]);
    return parent[x];
  }

  public boolean union(int x, int y) {
    if (find(x) == find(y))
      return false;
    parent[find(x)] = find(y);
    return true;
  }
}