/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function (matrix) {
  let m = matrix.length;
  let n = matrix[0].length;
  let maxSide = 0;
  const dp = Array(m + 1)
    .fill()
    .map(() => Array(n + 1).fill(0));
  for (let i = 1; i <= m; i++) {
    for (let j = 1; j <= n; j++) {
      if (matrix[i - 1][j - 1] === "1") {
        dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;
      }
      maxSide = Math.max(maxSide, dp[i][j]);
    }
  }
  return maxSide * maxSide;
};
