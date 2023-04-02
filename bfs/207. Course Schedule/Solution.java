class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
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
    int cnt = 0;
    while (!q.isEmpty()) {
      int cur = q.poll();
      cnt++;
      for (int nei : graph.getOrDefault(cur, new ArrayList<>())) {
        indegree[nei]--;
        if (indegree[nei] == 0)
          q.offer(nei);
      }
    }
    return cnt == numCourses;
  }
}