/**
 * @param {number} m
 * @param {number} n
 * @param {number[][]} positions
 * @return {number[]}
 */
var numIslands2 = function (m, n, positions) {
  const direction = [-1, 0, 1, 0, -1];
  let dsu = new DSU(m * n);
  const isIsland = Array(m)
    .fill()
    .map(() => Array(n).fill(false));
  let res = [];
  let count = 0;
  for (const pos of positions) {
    if (isIsland[pos[0]][pos[1]]) {
      res.push(count);
      continue;
    }
    isIsland[pos[0]][pos[1]] = true;
    count++;
    for (let k = 0; k < 4; k++) {
      const x = pos[0] + direction[k];
      const y = pos[1] + direction[k + 1];
      if (x < 0 || x >= m || y < 0 || y >= n || isIsland[x][y] === false)
        continue;
      let set1 = dsu.find(pos[0] * n + pos[1]); //序列化，将二维压成一维
      let set2 = dsu.find(x * n + y);
      if (set1 != set2) {
        dsu.union(set2, set1);
        count--;
      }
    }
    res.push(count);
  }
  return res;
};

class DSU {
  constructor(n) {
    this.parent = new Array(n);
    for (let i = 0; i < n; i++) {
      this.parent[i] = i;
    }
  }
  find(x) {
    if (this.parent[x] !== x) {
      this.parent[x] = this.find(this.parent[x]);
    }
    return this.parent[x];
  }
  union(x, y) {
    this.parent[this.find(x)] = this.find(y);
  }
}
