class Solution {
  public int countComponents(int n, int[][] edges) {
    int res = 0;
    DSU dsu = new DSU(n);
    for (int[] edge : edges) {
      dsu.union(edge[0], edge[1]);
    }
    for (int i = 0; i < n; i++) {
      if (dsu.find(i) == i)
        res++;
    }
    return res;
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

  public void union(int x, int y) {
    parent[find(x)] = find(y);
  }
}