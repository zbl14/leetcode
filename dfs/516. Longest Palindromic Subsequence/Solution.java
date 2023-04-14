class Solution {
  private int[][] memo;

  public int longestPalindromeSubseq(String s) {
    int n = s.length();
    memo = new int[n][n];
    return dfs(s, 0, n - 1);
  }

  private int dfs(String s, int l, int r) {
    if (memo[l][r] != 0)
      return memo[l][r];
    if (l > r)
      return 0;
    if (l == r)
      return 1;

    if (s.charAt(l) == s.charAt(r)) {
      memo[l][r] = dfs(s, l + 1, r - 1) + 2;
    } else {
      memo[l][r] = Math.max(dfs(s, l + 1, r), dfs(s, l, r - 1));
    }
    return memo[l][r];
  }
}