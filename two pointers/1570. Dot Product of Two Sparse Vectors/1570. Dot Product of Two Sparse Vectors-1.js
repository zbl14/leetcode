/**
 * @param {number[]} nums
 * @return {SparseVector}
 */
var SparseVector = function (nums) {
  this.map = new Map();
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] !== 0) {
      this.map.set(i, nums[i]);
    }
  }
};

// Return the dotProduct of two sparse vectors
/**
 * @param {SparseVector} vec
 * @return {number}
 */
SparseVector.prototype.dotProduct = function (vec) {
  if (vec.map.size < this.map.size) return vec.dotProduct(this);
  const map1 = this.map;
  const map2 = vec.map;
  let sum = 0;
  for (const key of map1.keys()) {
    if (map2.has(key)) sum += map1.get(key) * map2.get(key);
  }
  return sum;
};

// Your SparseVector object will be instantiated and called as such:
// let v1 = new SparseVector(nums1);
// let v2 = new SparseVector(nums2);
// let ans = v1.dotProduct(v2);
