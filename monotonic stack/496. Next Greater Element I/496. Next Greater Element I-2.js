/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */

// TC = O(m + n); SC = O(n)
var nextGreaterElement = function (nums1, nums2) {
  const map = new Map();
  const stack = [];
  // O(n)
  nums2.forEach((num) => {
    while (stack.length && num > stack[stack.length - 1]) {
      map.set(stack.pop(), num);
    }
    stack.push(num);
  });
  // O(m) ~ O(n)
  const result = nums1.map((num) => (map.has(num) ? map.get(num) : -1));
  return result;
};

// var nextGreaterElement = function(nums1, nums2) {
//   const map = new Map();
//   const stack = []
//   for(let i = nums2.length - 1; i >=0; i--){
//     while(stack.length && nums2[i] >= stack[stack.length - 1]) stack.pop();
//     map.set(nums2[i], stack.length === 0 ? -1 : stack[stack.length - 1])
//     stack.push(nums2[i]);
//   }
//   const res = nums1.map((num) => map.get(num))
//   return res
// };
