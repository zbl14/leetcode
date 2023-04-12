// dfs, TLE
// class Solution {
//   public int minDistance(String word1, String word2) {
//     return dfs(word1, word2, word1.length(), word2.length());
//   }

//   private int dfs(String word1, String word2, int idx1, int idx2) {
//     if (idx1 == 0)
//       return idx2;
//     if (idx2 == 0)
//       return idx1;
//     if (word1.charAt(idx1 - 1) == word2.charAt(idx2 - 1)) {
//       return dfs(word1, word2, idx1 - 1, idx2 - 1);
//     } else {
//       int insert = dfs(word1, word2, idx1, idx2 - 1);
//       int delete = dfs(word1, word2, idx1 - 1, idx2);
//       int replace = dfs(word1, word2, idx1 - 1, idx2 - 1);
//       return Math.min(Math.min(insert, delete), replace) + 1;
//     }
//   }
// }

// dfs top-down + memoization, TC = O(mn), SC = O(mn)
// where m is the length of word1 and n is the length of word2
class Solution {
  private int[][] memo;

  public int minDistance(String word1, String word2) {
    memo = new int[word1.length() + 1][word2.length() + 1];
    return dfs(word1, word2, word1.length(), word2.length());
  }

  private int dfs(String word1, String word2, int idx1, int idx2) {
    if (idx1 == 0)
      return idx2;
    if (idx2 == 0)
      return idx1;
    if (memo[idx1][idx2] != 0)
      return memo[idx1][idx2];
    int minEditDistance = 0;
    if (word1.charAt(idx1 - 1) == word2.charAt(idx2 - 1)) {
      minEditDistance = dfs(word1, word2, idx1 - 1, idx2 - 1);
    } else {
      int insert = dfs(word1, word2, idx1, idx2 - 1);
      int delete = dfs(word1, word2, idx1 - 1, idx2);
      int replace = dfs(word1, word2, idx1 - 1, idx2 - 1);
      minEditDistance = Math.min(Math.min(insert, delete), replace) + 1;
    }
    memo[idx1][idx2] = minEditDistance;
    return minEditDistance;
  }
}
