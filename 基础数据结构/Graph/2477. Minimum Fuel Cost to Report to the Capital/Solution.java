// dfs
// class Solution {
//     private long fuel;
//     public long minimumFuelCost(int[][] roads, int seats) {
//         if(roads.length == 0) return 0;
//         Map<Integer, List<Integer>> adj = new HashMap<>();
//         for(int[] road : roads){
//             int a = road[0];
//             int b = road[1];
//             adj.computeIfAbsent(a, k -> new ArrayList<Integer>()).add(b);
//             adj.computeIfAbsent(b, k -> new ArrayList<Integer>()).add(a);
//         }
//         dfs(0, -1, adj, seats);
//         return fuel;
//     }

//     private long dfs(int node, int parent, Map<Integer, List<Integer>> adj, int seats){
//         int reps = 1;
//         if(!adj.containsKey(node)) return reps;
//         for(int child: adj.get(node)){
//             if(child == parent) continue;
//             reps += dfs(child, node, adj, seats);
//         }
//         if(node != 0){
//             fuel += Math.ceil((double) reps / seats);
//         }
//         return reps;
//     }
// }

// bfs
class Solution {
  public long minimumFuelCost(int[][] roads, int seats) {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    int[] degree = new int[roads.length + 1];
    for (int[] road : roads) {
      adj.computeIfAbsent(road[0], k -> new ArrayList<Integer>()).add(road[1]);
      adj.computeIfAbsent(road[1], k -> new ArrayList<Integer>()).add(road[0]);
      degree[road[0]]++;
      degree[road[1]]++;
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i < roads.length + 1; i++) {
      if (degree[i] == 1)
        q.offer(i);
    }
    int[] reps = new int[roads.length + 1];
    Arrays.fill(reps, 1);
    long fuel = 0;

    while (!q.isEmpty()) {
      int cur = q.poll();
      fuel += Math.ceil((double) reps[cur] / seats);

      for (int nei : adj.get(cur)) {
        degree[nei]--;
        reps[nei] += reps[cur];
        if (degree[nei] == 1 && nei != 0)
          q.offer(nei);
      }
    }
    return fuel;
  }
}