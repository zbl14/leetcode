// class Solution {
//     public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
//         if(n == 1) return 0;
//         Map<Integer, List<Integer>> adj = new HashMap<>();
//         for(int i = 0; i < n; i++){
//             if(manager[i] != -1) {
//                 adj.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);
//             }
//         }

//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[]{headID, 0});
//         int res = 0;

//         while(!q.isEmpty()){
//             int[] cur = q.poll();
//             int id = cur[0];
//             int elapsed = cur[1];
//             res = Math.max(res, elapsed);          
//             if (adj.containsKey(id)) { 
//                 for (int subId : adj.get(id)) { 
//                     q.offer(new int[]{subId, elapsed + informTime[id]});
//                 }
//             }
//         }
//         return res;
//     }
// }

// class Solution {
//     public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
//         Map<Integer, List<Integer>> adj = new HashMap<>();
//         for(int i = 0; i < n; i++){
//             if (manager[i] != -1) { 
//                 adj.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);
//             }
//         }
//         return dfs(headID, adj, informTime);
//     }

//     private int dfs(int id, Map<Integer, List<Integer>> adj, int[] informTime) {
//         if (!adj.containsKey(id)) {
//             return 0;
//         }
//         int max = 0;
//         for(int subId : adj.get(id)) {
//             max = Math.max(max, dfs(subId, adj, informTime));
//         }
//         return max + informTime[id];
//     }
// }

class Solution {
  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    int max = 0;
    for (int i = 0; i < n; i++) {
      if (informTime[i] == 0)
        continue; // This will no further contribute to ans so no need to traverse
      max = Math.max(max, dfs(i, manager, informTime));
    }
    return max;
  }

  private int dfs(int emp, int[] manager, int[] informTime) {
    if (manager[emp] != -1) {
      informTime[emp] += dfs(manager[emp], manager, informTime);
      manager[emp] = -1; // Acting like dp to not traverse again
    }
    return informTime[emp];
  }
}
