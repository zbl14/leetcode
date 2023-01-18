// insert([x,y]) insert an object with key x and value y
// get(x) return the value of an object with key x
// addToKey(x) add x to all key in map
// addToValue(x) add x to all value in map

// test
let map = new CustomMap();
map.insert([1, 2]);
map.insert([2, 3]);
map.addToValue(2);
map.addToKey(1);
map.get(3);

// TC = O(1)
const CustomMap = function () {
  this.map = new Map();
  this.keyCount = 0;
  this.valueCount = 0;
};

CustomMap.prototype.insert = function (nums) {
  let insertKey = nums[0];
  let insertValue = nums[1];
  this.map.set(insertKey, insertValue);
};

CustomMap.prototype.get = function (key) {
  let newKey = key - this.keyCount;
  if (!this.map.has(newKey)) return -1;
  let newValue = map.get(newKey);
  return newValue + this.valueCount;
};

CustomMap.prototype.addToKey = function (num) {
  this.keyCount += num;
};

CustomMap.prototype.addToValue = function (num) {
  this.valueCount += num;
};
