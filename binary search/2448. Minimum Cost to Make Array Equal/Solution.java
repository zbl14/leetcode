// TC = O(nlogk), SC = O(1), where n is the length of the input array and k is the difference between maximum and minimum value of nums[i]
class Solution {
  public long minCost(int[] nums, int[] cost) {
    int maxNum = Integer.MIN_VALUE;
    int minNum = Integer.MAX_VALUE;
    for (int num : nums) {
      minNum = Math.min(minNum, num);
      maxNum = Math.max(maxNum, num);
    }
    if (minNum == maxNum)
      return 0;
    int l = minNum;
    int r = maxNum;
    long res = Long.MAX_VALUE;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      long cost1 = getCost(nums, cost, mid);
      long cost2 = getCost(nums, cost, mid + 1);
      res = Math.min(cost1, cost2);

      if (cost1 > cost2) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return res;
  }

  private long getCost(int[] nums, int[] cost, int base) {
    long res = 0;
    for (int i = 0; i < nums.length; i++) {
      res += (long) Math.abs(nums[i] - base) * cost[i];
    }
    return res;
  }
}