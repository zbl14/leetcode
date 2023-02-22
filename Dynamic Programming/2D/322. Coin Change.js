/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
// TC = O(s*n) where s is amount, n is the types of coins, SC = O(s)
var coinChange = function (coins, amount) {
  const dp = Array(amount + 1).fill(amount + 1);
  dp[0] = 0;
  for (let i = 1; i <= amount; i++) {
    for (let j = 0; j < coins.length; j++) {
      if (coins[j] <= i) {
        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
      }
    }
  }
  return dp[amount] > amount ? -1 : dp[amount];
};
