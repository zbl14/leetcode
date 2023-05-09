// TC = O(nlogn)
// class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         return nums[nums.length / 2];
//     }
// }

// divide and conquer, TC = O(nlogn), SC = O(logn)
// class Solution {
//     public int majorityElement(int[] nums) {
//         return divide(nums, 0, nums.length - 1);
//     }

//     private int divide(int[] nums, int lo, int hi){
//         if(lo == hi) return nums[lo];
//         int mid = lo + (hi - lo) / 2;
//         int leftRes = divide(nums, lo, mid);
//         int rightRes = divide(nums, mid + 1, hi);
//         if(leftRes == rightRes) return leftRes;
//         int leftCount = conquer(nums, leftRes, lo, hi);
//         int rightCount = conquer(nums, rightRes, lo, hi);
//         return leftCount > rightCount ? leftRes : rightRes;
//     }

//     private int conquer(int[] nums, int target, int lo, int hi){
//         int count = 0;
//         for(int i = lo; i <= hi; i++){
//             if(nums[i] == target) count++;
//         }
//         return count;
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