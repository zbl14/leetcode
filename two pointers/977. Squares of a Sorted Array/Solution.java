class Solution {
  public int[] sortedSquares(int[] nums) {
    int res[] = new int[nums.length];
    int l = 0;
    int r = nums.length - 1;

    for (int i = nums.length - 1; i >= 0; i--) {
      int square;
      if (Math.abs(nums[l]) < Math.abs(nums[r])) {
        square = nums[r];
        r--;
      } else {
        square = nums[l];
        l++;
      }
      res[i] = square * square;
    }

    return res;
  }
}