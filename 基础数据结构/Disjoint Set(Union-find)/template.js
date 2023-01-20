// DSU template with path compression
// if m operations, either union and find, are applied to n elements,
// the total run time is O(m log* n), where log* is the iterated logarithm
class DSU {
  constructor(n) {
    this.parent = new Array(n);
    for (let i = 0; i < n; i++) {
      this.parent[i] = i;
    }
  }
  find(x) {
    if (this.parent[x] !== x) {
      this.parent[x] = this.find(this.parent[x]); // path compression
    }
    return this.parent[x];
  }
  union(x, y) {
    let rootX = this.find(x);
    let rootY = this.find(y);
    this.parent[rootX] = rootY;
  }
}

// improve by weight(size)
class DSU {
  constructor(n) {
    this.parent = new Array(n);
    this.size = new Array(n).fill(1);
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
    let rootX = this.find(x);
    let rootY = this.find(y);
    if (rootX === rootY) return;

    if (this.size[rootX] < this.size[rootY]) {
      [rootX, rootY] = [rootY, rootX];
    }
    this.parent[rootY] = rootX;
    this.size[rootX] += this.size[rootY];
  }
}

// improve by rank, rank is better than size
// find的速度是由height决定的，size大不一定height大
class DSU {
  constructor(n) {
    this.parent = new Array(n);
    this.rank = new Array(n).fill(0);
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
    let rootX = this.find(x);
    let rootY = this.find(y);
    if (rootX === rootY) {
      return;
    }
    if (this.rank[rootX] < this.rank[rootY]) {
      this.parent[rootX] = rootY;
    } else if (this.rank[rootX] > this.rank[rootY]) {
      this.parent[rootY] = rootX;
    } else {
      this.parent[rootY] = rootX;
      this.rank[rootX]++;
    }
  }
}
