/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function (n) {
  const res = [];
  dfs(n, n, "", res);
  return res;
};

const dfs = (l, r, curStr, res) => {
  if (l === 0 && r === 0) res.push(curStr);
  if (l > 0) dfs(l - 1, r, curStr + "(", res);
  if (r > l) dfs(l, r - 1, curStr + ")", res);
};
