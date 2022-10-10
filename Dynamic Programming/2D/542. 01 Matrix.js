/**
 * @param {number[][]} mat
 * @return {number[][]}
 */
var updateMatrix = function (mat) {
  let m = mat.length;
  let n = mat[0].length;
  let res = Array(m)
    .fill()
    .map(() => Array(n).fill(Infinity));

  for (let x = 0; x < m; x++) {
    for (let y = 0; y < n; y++) {
      if (mat[x][y] === 0) {
        res[x][y] = 0;
      } else {
        if (x > 0) res[x][y] = Math.min(res[x][y], res[x - 1][y] + 1);
        if (y > 0) res[x][y] = Math.min(res[x][y], res[x][y - 1] + 1);
      }
    }
  }

  for (let x = m - 1; x >= 0; x--) {
    for (let y = n - 1; y >= 0; y--) {
      if (x < m - 1) res[x][y] = Math.min(res[x][y], res[x + 1][y] + 1);
      if (y < n - 1) res[x][y] = Math.min(res[x][y], res[x][y + 1] + 1);
    }
  }
  return res;
};
