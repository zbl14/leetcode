class Solution {
  public long countPairs(int n, int[][] edges) {
    DSU dsu = new DSU(n);
    for (int[] edge : edges) {
      dsu.union(edge[0], edge[1]);
    }

    Map<Integer, Integer> sizes = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int parent = dsu.find(i);
      sizes.put(parent, sizes.getOrDefault(parent, 0) + 1);
    }

    long unreachablePairs = 0;
    long remainingNodes = n;
    for (int size : sizes.values()) {
      remainingNodes -= size;
      unreachablePairs += size * remainingNodes;
    }
    return unreachablePairs;
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