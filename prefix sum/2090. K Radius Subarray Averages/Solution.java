// prefix sum, TC = O(n), SC = O(n)
// class Solution {
//     public int[] getAverages(int[] nums, int k) {
//         if(k == 0) return nums;
//         if(nums.length < 2 * k + 1){
//             Arrays.fill(nums, -1);
//             return nums;
//         }
//         long[] sums = new long[nums.length + 1];
//         for(int i = 0; i < nums.length; i++){
//             sums[i + 1] = sums[i] + nums[i];
//         }
//         for(int i = 0; i < nums.length; i++){
//             if(i < k){
//                 nums[i] = -1;
//             } else if (i >= nums.length - k){
//                 nums[i] = -1;
//             } else {
//                 long subArraySum = sums[i + k + 1] - sums[i - k];
//                 int average = (int)(subArraySum / (2 * k + 1));
//                 nums[i] = average;
//             }
//         }
//         return nums;
//     }
// }

// sliding window, TC = O(n), SC = O(n)
class Solution {
  public int[] getAverages(int[] nums, int k) {
    if (k == 0)
      return nums;
    int[] res = new int[nums.length];
    Arrays.fill(res, -1);
    if (nums.length < 2 * k + 1) {
      return res;
    }
    int l = 0;
    long curSum = 0;
    for (int r = 0; r < nums.length; r++) {
      curSum += nums[r];
      if ((r - l) == 2 * k) {
        res[r - k] = (int) (curSum / (2 * k + 1));
        curSum -= nums[l];
        l++;
      }
    }
    return res;
  }
}