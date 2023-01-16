/**
 * @param {number[][]} isConnected
 * @return {number}
 */
var findCircleNum = function (isConnected) {
  const row = isConnected.length;
  const col = isConnected.length;
  let dsu = new DSU(row);
  for (let i = 0; i < row; i++) {
    for (let j = 0; j < col; j++) {
      if (isConnected[i][j] === 1) dsu.union(i, j);
    }
  }
  let res = 0;
  for (let i = 0; i < row; i++) if (dsu.find(i) === i) res++;
  return res;
};

class DSU {
  constructor(n) {
    this.parent = new Array(n);
    // this.rank = new Array(n).fill(0);
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
    // let rootX = this.find(x);
    // let rootY = this.find(y);
    // if(rootX === rootY) return;
    // if(this.rank[rootX] < this.rank[rootY]){
    //   this.parent[rootX] = rootY;
    // } else if (this.rank[rootX] > this.rank[rootY]) {
    //   this.parent[rootY] = rootX;
    // } else {
    //   this.parent[rootY] = rootX;
    //   this.rank[rootX]++
    // }
  }
}
