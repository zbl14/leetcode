class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] res = new int[numCourses];
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] indegree = new int[numCourses];
    for (int[] prerequisite : prerequisites) {
      graph.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
      indegree[prerequisite[0]]++;
    }
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < indegree.length; i++) {
      if (indegree[i] == 0)
        q.offer(i);
    }
    int idx = 0;
    while (!q.isEmpty()) {
      int cur = q.poll();
      res[idx++] = cur;
      for (int nei : graph.getOrDefault(cur, new ArrayList<>())) {
        indegree[nei]--;
        if (indegree[nei] == 0)
          q.offer(nei);
      }
    }
    if (idx != numCourses)
      return new int[0];
    else
      return res;
  }
}