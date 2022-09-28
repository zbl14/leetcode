/**
 * @param {number[][]} grid
 * @return {number}
 */
 var maxAreaOfIsland = function(grid) {
  let maxArea = 0;
  for(let i = 0; i < grid.length; i++) {
      for(let j = 0; j < grid[i].length; j++) {
          if(grid[i][j] === 1) {
              let area = dfs(grid, i, j)
              if(maxArea < area) {
                  maxArea = area;
              }
          }
      }
  }
  return maxArea
};

// r means row, c means column
let dfs = (grid, r , c) => {
  if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] === 0) {
      return 0
  }
  grid[r][c] = 0;
  return 1 + dfs(grid, r, c+1) + dfs(grid, r, c-1) + dfs(grid, r+1, c) + dfs(grid, r-1, c);
}