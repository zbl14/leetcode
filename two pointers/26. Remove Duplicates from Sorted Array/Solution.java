class Solution {
  public int removeDuplicates(int[] nums) {
    int n = nums.length;
    if (n <= 1)
      return n;
    int i = 0;
    int j = 1;
    while (j < nums.length) {
      if (nums[i] < nums[j]) {
        i++;
        nums[i] = nums[j];
      } else {
        j++;
      }
    }
    return i + 1;
  }
}