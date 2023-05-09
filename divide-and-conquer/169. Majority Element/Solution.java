// TC = O(nlogn)
// class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         return nums[nums.length / 2];
//     }
// }

// TC = O(n), SC = O(1)
class Solution {
  int candidate;

  public int majorityElement(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (count == 0)
        candidate = nums[i];
      count += (candidate == nums[i]) ? 1 : -1;
    }
    return candidate;
  }
}