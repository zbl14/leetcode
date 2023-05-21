class Solution {
  private int res = Integer.MAX_VALUE;

  public int minimumTimeRequired(int[] jobs, int k) {
    Arrays.sort(jobs);
    if (jobs.length == k)
      return jobs[k - 1];

    int[] workers = new int[k];
    Arrays.fill(workers, 0);
    backtracking(jobs, k, jobs.length - 1, workers);
    return res;
  }

  private void backtracking(int[] jobs, int k, int lastJobIdx, int[] workers) {
    if (lastJobIdx < 0) {
      res = Math.min(res, findMax(workers));
      return;
    }
    if (findMax(workers) >= res)
      return;
    for (int i = 0; i < k; i++) {
      if (i > 0 && workers[i] == workers[i - 1])
        continue;
      workers[i] += jobs[lastJobIdx];
      backtracking(jobs, k, lastJobIdx - 1, workers);
      workers[i] -= jobs[lastJobIdx];
    }
  }

  private int findMax(int[] workers) {
    int max = Integer.MIN_VALUE;
    for (int worker : workers) {
      max = Math.max(max, worker);
    }
    return max;
  }
}