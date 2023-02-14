/**
 * @param {number[][]} grid
 * @return {number[]}
 */
var findBall = function (grid) {
  const res = Array(grid[0].length).fill(0);
  for (let i = 0; i < grid[0].length; i++) {
    res[i] = findBallPath(0, i, grid);
  }
  return res;
};

const findBallPath = function (row, col, grid) {
  if (row === grid.length) return col;
  let nextCol = col + grid[row][col];
  if (
    nextCol < 0 ||
    nextCol > grid[0].length ||
    grid[row][col] !== grid[row][nextCol]
  )
    return -1;
  return findBallPath(row + 1, nextCol, grid);
};
