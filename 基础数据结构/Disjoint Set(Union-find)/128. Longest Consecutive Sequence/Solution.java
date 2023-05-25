// DSU by rank
// class Solution {
//     public int longestConsecutive(int[] nums) {
//         int n = nums.length;
//         if(n <= 1) return n;
//         Map<Integer, Integer> visited = new HashMap<>();
//         DSU dsu = new DSU(n);
//         for(int i = 0; i < n; i++){
//             if(visited.containsKey(nums[i])) continue;
//             visited.put(nums[i], i);
//             if(visited.containsKey(nums[i] + 1)) dsu.union(visited.get(nums[i] + 1), i);
//             if(visited.containsKey(nums[i] - 1)) dsu.union(visited.get(nums[i] - 1), i);
//         }

//         Map<Integer, Integer> sizes = new HashMap<>();
//         for(int i = 0; i < n; i++){
//             int parent = dsu.find(i);
//             sizes.put(parent, sizes.getOrDefault(parent, 0) + 1);
//         }

//         int maxSize = 0;
//         for(int size : sizes.values()) maxSize = Math.max(maxSize, size);
//         return maxSize;
//     }
// }

// class DSU {
//   int parent[];
//   int rank[];

//   public DSU(int n) {
//     parent = new int[n];
//     rank = new int[n];
//     for (int i = 0; i < n; i++) {
//       parent[i] = i;
//     }
//   }

//   public int find(int x) {
//     if (parent[x] != x)
//       parent[x] = find(parent[x]);
//     return parent[x];
//   }

//   public void union(int x, int y) {
//     int rootX = find(x);
//     int rootY = find(y);

//     if (rootX == rootY)
//       return;

//     if (rank[rootX] < rank[rootY]) {
//       parent[rootX] = rootY;
//     } else if (rank[rootX] > rank[rootY]) {
//       parent[rootY] = rootX;
//     } else {
//       parent[rootY] = rootX;
//       rank[rootX]++;
//     }
//   }
// }

// DSU by size
class Solution {
  public int longestConsecutive(int[] nums) {
    int n = nums.length;
    if (n <= 1)
      return n;
    Map<Integer, Integer> visited = new HashMap<>();
    DSU dsu = new DSU(n);
    for (int i = 0; i < n; i++) {
      if (visited.containsKey(nums[i]))
        continue;
      visited.put(nums[i], i);
      if (visited.containsKey(nums[i] + 1))
        dsu.union(visited.get(nums[i] + 1), i);
      if (visited.containsKey(nums[i] - 1))
        dsu.union(visited.get(nums[i] - 1), i);
    }
    return dsu.findMaxSize();
  }
}

class DSU {
  int[] parent;
  int[] size;

  public DSU(int n) {
    parent = new int[n];
    size = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      size[i] = 1;
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

    if (size[rootX] < size[rootY]) {
      int tmp = rootX;
      rootX = rootY;
      rootY = tmp;
    }
    parent[rootY] = rootX;
    size[rootX] += size[rootY];
  }

  public int findMaxSize() {
    int max = 0;
    for (int s : size) {
      max = Math.max(max, s);
    }
    return max;
  }
}