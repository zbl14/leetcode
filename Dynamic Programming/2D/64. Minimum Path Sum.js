/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
  // save space: we just use the original grid to calcuate the min path sum
  // grid[i][j] = min path sum of i x j grid
  let m = grid.length;
  let n = grid[0].length;

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      // grid[0][0] itself contains the min path sum
      if (i === 0 && j === 0) continue;
      // first row: grid[i][j] = previous grid(left) + current val
      if (i === 0) grid[i][j] += grid[i][j - 1];
      // first column: grid[i][j] = previous grid(top) + current val
      else if (j === 0) grid[i][j] += grid[i - 1][j];
      // grid[i][j] = get the min of previous grid(top/left) + current val
      else grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
    }
  }
  return grid[m - 1][n - 1];
};
