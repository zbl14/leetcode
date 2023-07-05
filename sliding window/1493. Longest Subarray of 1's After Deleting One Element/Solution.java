class Solution {
  public static void main(String[] args) {
    int[] nums1 = { 1, 1, 0, 1 };
    int[] nums2 = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
    int[] nums3 = { 1, 1, 1 };

    Solution solution = new Solution();
    System.out.println(solution.longestSubarray(nums1));
    System.out.println(solution.longestSubarray(nums2));
    System.out.println(solution.longestSubarray(nums3));
  }

  public int longestSubarray(int[] nums) {
    int zeroCnt = 0;
    int res = 0;
    int l = 0;
    for (int r = 0; r < nums.length; r++) {
      zeroCnt += (nums[r] == 0 ? 1 : 0);

      while (zeroCnt > 1) {
        zeroCnt -= (nums[l] == 0 ? 1 : 0);
        l++;
      }
      res = Math.max(res, r - l);
    }
    return res;
  }
}