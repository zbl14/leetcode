class Solution {
  private int total = 0;

  public int findTargetSumWays(int[] nums, int target) {
    for (int num : nums)
      total += num;
    int[][] memo = new int[nums.length][2 * total + 1];
    for (int[] row : memo)
      Arrays.fill(row, Integer.MIN_VALUE);
    return dfs(nums, 0, 0, target, memo);
  }

  private int dfs(int[] nums, int i, int sum, int target, int[][] memo) {
    if (i == nums.length) {
      if (sum == target) {
        return 1;
      } else {
        return 0;
      }
    } else {
      if (memo[i][sum + total] != Integer.MIN_VALUE) {
        return memo[i][sum + total];
      }
      int add = dfs(nums, i + 1, sum + nums[i], target, memo);
      int substract = dfs(nums, i + 1, sum - nums[i], target, memo);
      memo[i][sum + total] = add + substract;
      return memo[i][sum + total];
    }
  }
}