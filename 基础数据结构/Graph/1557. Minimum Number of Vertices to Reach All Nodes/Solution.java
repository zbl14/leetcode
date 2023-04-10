class Solution {
  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    boolean[] indegreeNotZero = new boolean[n];
    for (List<Integer> edge : edges) {
      indegreeNotZero[edge.get(1)] = true;
    }

    List<Integer> indegreeZero = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (!indegreeNotZero[i])
        indegreeZero.add(i);
    }

    return indegreeZero;
  }
}