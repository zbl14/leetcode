/**
 * @param {number[]} nums
 * @return {number}
 */
// non class version, no diff in TC and SC. TC = O(nm), SC = O(nm)
function findMaximumXOR(nums) {
  let res = -Infinity;
  let root = { children: {} };
  for (const num of nums) {
    addNum(root, num);
  }
  for (const num of nums) {
    res = Math.max(res, findMaxXor(root, num));
  }
  return res;
}

function addNum(root, num) {
  let curr = root;
  for (let i = 31; i >= 0; i--) {
    const currBit = (num >> i) & 1;
    if (!curr.children[currBit]) {
      curr.children[currBit] = { children: {} };
    }
    curr = curr.children[currBit];
  }
}

function findMaxXor(root, num) {
  let sum = 0;
  let curr = root;
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
