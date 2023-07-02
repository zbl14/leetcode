class Solution {
  public int maximumRequests(int n, int[][] requests) {
    if (requests == null || requests.length == 0)
      return 0;
    int[] indegree = new int[n];
    return backtracking(0, requests, indegree, n, 0);
  }

  public int backtracking(int start, int[][] requests, int[] indegree, int n, int cnt) {
    if (start == requests.length) {
      for (int i = 0; i < n; i++) {
        if (indegree[i] != 0)
          return 0;
      }
      return cnt;
    }

    indegree[requests[start][0]]--;
    indegree[requests[start][1]]++;
    int take = backtracking(start + 1, requests, indegree, n, cnt + 1);

    indegree[requests[start][0]]++;
    indegree[requests[start][1]]--;
    int notTake = backtracking(start + 1, requests, indegree, n, cnt);
    return Math.max(take, notTake);
  }
}