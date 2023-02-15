/**
 * @param {number} n
 * @return {number}
 */
var numTrees = function (n) {
  let memo = Array(n + 1);

  const dfs = (num, memo) => {
    if (num === 0 || num === 1) return 1;
    if (memo[num] !== null) return memo[num];
    let sum = 0;
    for (let i = 1; i <= num; i++) {
      sum += dfs(i - 1, memo) * dfs(num - i, memo);
    }
    return (memo[num] = sum);
  };

  return dfs(n, memo);
};
