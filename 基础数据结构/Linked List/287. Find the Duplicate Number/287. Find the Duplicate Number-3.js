/**
 * @param {number[]} nums
 * @return {number}
 */
// TC = O(n), SC = O(1)
var findDuplicate = function (nums) {
  let fast = nums[0];
  let slow = nums[0];
  while (true) {
    fast = nums[nums[fast]];
    slow = nums[slow];
    if (fast === slow) {
      fast = nums[0];
      while (fast !== slow) {
        fast = nums[fast];
        slow = nums[slow];
      }
      return slow;
    }
  }
};
