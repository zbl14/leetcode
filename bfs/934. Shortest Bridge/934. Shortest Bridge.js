/**
 * @param {number[][]} grid
 * @return {number}
 */
var shortestBridge = function (grid) {
  const rows = grid.length;
  const cols = grid[0].length;
  let step = 0;
  const direction = [-1, 0, 1, 0, -1];
  const queue = [];

  const dfs = (r, c) => {
    // dfs find the first island
    if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] === 2) return;
    if (grid[r][c] === 0) {
      queue.push([r, c]);
      return;
    }
    // mark the 1st island with 2
    grid[r][c] = 2;
    // record the 1st island in queue
    queue.push([r, c]);
    for (let k = 0; k < 4; k++) {
      const newR = r + direction[k];
      const newC = c + direction[k + 1];
      dfs(newR, newC);
    }
  };

  //use bfs to search the 2nd island
  const bfs = () => {
    while (queue.length) {
      let size = queue.length;
      step++;
      while (size--) {
        const [i, j] = queue.shift();
        // 出队列向四周扩散
        for (let k = 0; k < 4; k++) {
          const newI = i + direction[k];
          const newJ = j + direction[k + 1];
          if (
            newI < 0 ||
            newI >= rows ||
            newJ < 0 ||
            newJ >= cols ||
            grid[newI][newJ === 2]
          ) {
            continue;
          }
          // 2nd island found, return smallest step
          if (grid[newI][newJ] === 1) {
            return step;
          }
          // merge to 1st island to prevent searching this location again
          if (grid[newI][newJ] === 0) {
            grid[newI][newJ] = 2;
            queue.push([newI, newJ]);
          }
        }
      }
    }
  };

  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < cols; j++) {
      if (grid[i][j] === 1) {
        dfs(i, j);
        return bfs();
      }
    }
  }
  return step;
};
