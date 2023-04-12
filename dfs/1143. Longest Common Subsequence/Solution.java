class Solution {
  private int[][] memo;

  public int longestCommonSubsequence(String text1, String text2) {
    memo = new int[text1.length() + 1][text2.length() + 1];
    for (int i = 0; i < text1.length(); i++) {
      for (int j = 0; j < text2.length(); j++) {
        memo[i][j] = -1;
      }
    }
    return dfs(text1, text2, 0, 0);
  }

  private int dfs(String text1, String text2, int idx1, int idx2) {
    if (memo[idx1][idx2] != -1)
      return memo[idx1][idx2];
    int res = 0;
    if (text1.charAt(idx1) == text2.charAt(idx2)) {
      res = 1 + dfs(text1, text2, idx1 + 1, idx2 + 1);
    } else {
      res = Math.max(dfs(text1, text2, idx1 + 1, idx2), dfs(text1, text2, idx1, idx2 + 1));
    }
    memo[idx1][idx2] = res;
    return memo[idx1][idx2];
  }
}