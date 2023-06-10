class Solution {
  public long mostPoints(int[][] questions) {
    long[] memo = new long[questions.length];
    return dfs(questions, 0, memo);
  }

  private long dfs(int[][] questions, int i, long[] memo) {
    if (i >= questions.length) {
      return 0;
    }
    if (memo[i] != 0) {
      return memo[i];
    }
    long curQuestionPoints = questions[i][0];
    int skip = questions[i][1];

    long points = Math.max(curQuestionPoints + dfs(questions, i + skip + 1, memo), dfs(questions, i + 1, memo));

    memo[i] = points;

    return memo[i];
  }
}
