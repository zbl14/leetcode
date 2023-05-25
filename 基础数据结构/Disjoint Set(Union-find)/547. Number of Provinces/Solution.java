class Solution {
  public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    DSU dsu = new DSU(n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (isConnected[i][j] == 1)
          dsu.union(i, j);
      }
    }
    int res = 0;
    for (int i = 0; i < n; i++) {
      if (dsu.find(i) == i)
        res++;
    }
    return res;
  }
}

class DSU {
  int parent[];
  int rank[];

  public DSU(int n) {
    parent = new int[n];
    rank = new int[n];

    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  public int find(int x) {
    if (parent[x] != x)
      parent[x] = find(parent[x]);
    return parent[x];
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);

    if (rootX == rootY)
      return;

    if (rank[rootX] < rank[rootY]) {
      parent[rootX] = rootY;
    } else if (rank[rootX] > rank[rootY]) {
      parent[rootY] = rootX;
    } else {
      parent[rootY] = rootX;
      rank[rootX]++;
    }
  }
}