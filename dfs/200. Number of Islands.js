/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
  let res = 0;
  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      if (grid[i][j] === "1") {
        res++;
        dfs(grid, i, j);
      }
    }
  }
  return res;
};

let dfs = (grid, r, c) => {
  const direction = [-1, 0, 1, 0, -1];
  if (
    r < 0 ||
    r >= grid.length ||
    c < 0 ||
    c >= grid[0].length ||
    grid[r][c] === "0"
  ) {
    return;
  }
  grid[r][c] = "0";
  for (let k = 0; k < 4; k++) {
    const newR = r + direction[k];
    const newC = c + direction[k + 1];
    dfs(grid, newR, newC);
  }
};
