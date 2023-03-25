/**
 * @param {number[][]} maze
 * @param {number[]} start
 * @param {number[]} destination
 * @return {number}
 */
var shortestDistance = function (maze, start, destination) {
  let dist = Array(maze.length)
    .fill()
    .map(() => Array(maze[0].length).fill(Infinity));
  let rows = maze.length;
  let cols = maze[0].length;
  let directions = [-1, 0, 1, 0, -1];
  let queue = [start];
  dist[start[0]][start[1]] = 0;

  while (queue.length) {
    const cur = queue.shift();
    for (let k = 0; k < 4; k++) {
      let [i, j] = cur;
      let step = dist[i][j];
      // within boundary and not on the wall
      while (i >= 0 && j >= 0 && i < rows && j < cols && maze[i][j] === 0) {
        i += directions[k];
        j += directions[k + 1];
        step++;
      }
      // will be on the wall, take a step back
      i -= directions[k];
      j -= directions[k + 1];
      step--;
      // if step < dist[i][j] it means we either havent been there or we've now found
      // the shortest route to this location. Longer routes are ignored & not added to queue.
      if (step < dist[i][j]) {
        dist[i][j] = step;
        queue.push([i, j]);
      }
    }
  }
  return dist[destination[0]][destination[1]] !== Infinity
    ? dist[destination[0]][destination[1]]
    : -1;
};
