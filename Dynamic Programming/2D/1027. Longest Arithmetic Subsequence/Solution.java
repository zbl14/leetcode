class Solution {
  public int longestArithSeqLength(int[] nums) {
    int maxLen = 0;
    HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
    for (int r = 0; r < nums.length; r++) {
      dp[r] = new HashMap<>();
      for (int l = 0; l < r; l++) {
        int diff = nums[r] - nums[l];
        dp[r].put(diff, dp[l].getOrDefault(diff, 1) + 1);
        maxLen = Math.max(maxLen, dp[r].get(diff));
      }
    }
    return maxLen;
  }
}