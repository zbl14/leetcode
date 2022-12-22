/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function (n, k) {
  let res = [];
  backtrack(res, [], 1);
  return res;

  function backtrack(res, cur, index) {
    if (cur.length === k) {
      res.push([...cur]);
    } else {
      for (let i = index; i <= n; i++) {
        cur.push(i);
        backtrack(res, cur, i + 1);
        cur.pop();
      }
    }
  }
};
