// 410. Split Array Largest Sum;

class Solution {
  public int splitArray(int[] nums, int k) {
    int maxSum = 0;
    int minSum = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      maxSum += nums[i];
      minSum = minSum > nums[i] ? minSum : nums[i];
    }
    return binarySearch(minSum, maxSum, nums, k);
  }

  private int binarySearch(int lo, int hi, int[] nums, int k) {
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (isValid(mid, nums, k)) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return lo;
  }

  private boolean isValid(int subArrSum, int[] nums, int k) {
    int curSum = 0;
    int count = 1;
    for (int i = 0; i < nums.length; i++) {
      curSum += nums[i];
      if (curSum > subArrSum) {
        count++;
        if (count > k)
          return false;
        curSum = nums[i];
      }
    }
    return true;
  }
}
