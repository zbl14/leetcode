/**
 * @param {number[]} nums
 * @return {SparseVector}
 */
// 如果数据量大，使用hash map会有 hash collision
var SparseVector = function (nums) {
  this.map = [];
  for (let i = 0; i < nums.length; i++) {
    this.map.push([i, nums[i]]);
  }
};

// Return the dotProduct of two sparse vectors
/**
 * @param {SparseVector} vec
 * @return {number}
 */
SparseVector.prototype.dotProduct = function (vec) {
  if (vec.map.length > this.map.length) return vec.dotProduct(this);
  let sum = 0;
  for (let i = 0; i < vec.map.length; i++) {
    const index = vec.map[i][0];
    const value = vec.map[i][1];
    sum += value * this.binarySearch(index, 0, this.map.length - 1);
  }
  return sum;
};

SparseVector.prototype.binarySearch = function (index, left, right) {
  while (left <= right) {
    let mid = left + ((right - left) >> 1);
    if (this.map[mid][0] === index) {
      return this.map[mid][1];
    } else if (this.map[mid][0] < index) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }
  return 0;
};

// Your SparseVector object will be instantiated and called as such:
// let v1 = new SparseVector(nums1);
// let v2 = new SparseVector(nums2);
// let ans = v1.dotProduct(v2);
