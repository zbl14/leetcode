/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaximumXOR = function (nums) {
  let res = -Infinity;
  let root = new Trie();
  for (const num of nums) root.addNum(num);
  for (const num of nums) res = Math.max(res, root.findMaxXor(num));
  return res;
};

class TrieNode {
  constructor() {
    this.children = {};
  }
}

class Trie {
  constructor() {
    this.root = new TrieNode();
  }

  addNum(num) {
    let curr = this.root;
    for (let i = 31; i >= 0; i--) {
      const currBit = (num >> i) & 1;
      if (!curr.children[currBit]) {
        curr.children[currBit] = new TrieNode();
      }
      curr = curr.children[currBit];
    }
  }

  findMaxXor(num) {
    let sum = 0;
    let curr = this.root;
    for (let i = 31; i >= 0; i--) {
      const currBit = (num >> i) & 1;
      const otherChoice = currBit === 1 ? 0 : 1;
      if (!curr.children[otherChoice]) {
        curr = curr.children[currBit];
      } else {
        sum += 1 << i;
        curr = curr.children[otherChoice];
      }
    }
    return sum;
  }
}
