// dfs + memo, TC = O(n^2), SC = O(n)
class Solution {
  public int numTrees(int n) {
    int[] memo = new int[n + 1];
    return dfs(n, memo);
  }

  private int dfs(int n, int[] memo) {
    if (n == 0 || n == 1)
      return 1;
    if (memo[n] != 0)
      return memo[n];
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += dfs(i - 1, memo) * dfs(n - i, memo);
    }
    return memo[n] = sum;
  }
}