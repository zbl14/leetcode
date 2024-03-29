/**
 * @param {number[]} nums
 * @return {number}
 */
var longestConsecutive = function (nums) {
  let dsu = new DSU(nums.length);
  let visited = new Map();
  for (let i = 0; i < nums.length; i++) {
    if (visited.has(nums[i])) continue; // num可能重复
    visited.set(nums[i], i);
    if (visited.has(nums[i] + 1)) dsu.union(visited.get(nums[i] + 1), i);
    if (visited.has(nums[i] - 1)) dsu.union(visited.get(nums[i] - 1), i);
    console.log(dsu);
  }
  return dsu.findMax();
};

class DSU {
  constructor(n) {
    this.parent = new Array(n);
    this.size = new Array(n).fill(1);
    for (let i = 0; i < n; i++) {
      this.parent[i] = i;
    }
  }

  find(x) {
    if (this.parent[x] !== x) this.parent[x] = this.find(this.parent[x]);
    return this.parent[x];
  }

  union(x, y) {
    let rootX = this.find(x);
    let rootY = this.find(y);
    if (rootX === rootY) return;
    if (this.size[rootX] < this.size[rootY]) {
      [rootX, rootY] = [rootY, rootX];
    }
    this.parent[rootY] = rootX;
    this.size[rootX] += this.size[rootY];
  }

  findMax() {
    let max = 0;
    for (const s of this.size) {
      max = Math.max(max, s);
    }
    return max;
  }
}
