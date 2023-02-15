/**
 * @param {number} n
 * @return {number}
 */

//  核心考点其实为dp
// G(n): the number of unique BST for a sequence of length n
// F(i,n): the number of unique BST, where the number is served as the root of BST(1 <= i <= n)
var numTrees = function (n) {
  let dp = Array(n + 1).fill(0);
  dp[0] = 1;
  dp[1] = 1;
  for (let i = 2; i <= n; i++) {
    for (let j = 1; j <= i; j++) {
      dp[i] += dp[j - 1] * dp[i - j];
    }
  }
  return dp[n];
};
