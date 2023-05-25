class Solution {
  public int removeStones(int[][] stones) {
    DSU dsu = new DSU(stones.length);
    for (int i = 0; i < stones.length; i++) {
      for (int j = i + 1; j < stones.length; j++) {
        if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
          dsu.union(i, j);
        }
      }
    }
    int unions = 0;
    for (int i = 0; i < stones.length; i++) {
      if (dsu.find(i) == i)
        unions++;
    }
    return stones.length - unions;
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