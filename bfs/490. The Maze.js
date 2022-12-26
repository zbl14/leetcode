/**
 * @param {number[][]} maze
 * @param {number[]} start
 * @param {number[]} destination
 * @return {boolean}
 */
var hasPath = function (maze, start, destination) {
  let rows = maze.length;
  let cols = maze[0].length;
  let directions = [-1, 0, 1, 0, -1];
  let queue = [start];
  maze[start[0]][start[1]] = -1;

  while (queue.length) {
    const cur = queue.shift();
    if (cur[0] == destination[0] && cur[1] == destination[1]) return true;

    for (let k = 0; k < 4; k++) {
      let i = cur[0] + directions[k],
        j = cur[1] + directions[k + 1];
      // within boundary and not on the wall
      while (i >= 0 && j >= 0 && i < rows && j < cols && maze[i][j] != 1) {
        i += directions[k];
        j += directions[k + 1];
      }
      // will be on the wall, take a step back
      i -= directions[k];
      j -= directions[k + 1];

      //not visited, marke visted by setting it -1
      if (maze[i][j] != -1) {
        maze[i][j] = -1;
        queue.push([i, j]);
      }
    }
  }
  return false;
};
