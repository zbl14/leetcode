class Solution {
  public int thirdMax(int[] nums) {
    int first_max = nums[0];
    long second_max = Long.MIN_VALUE;
    long third_max = Long.MIN_VALUE;
    for (int num : nums) {
      if (first_max == num || second_max == num || third_max == num) {
        continue;
      }
      if (first_max <= num) {
        third_max = second_max;
        second_max = first_max;
        first_max = num;
      } else if (second_max <= num) {
        third_max = second_max;
        second_max = num;
      } else if (third_max <= num) {
        third_max = num;
      }
    }
    if (third_max == Long.MIN_VALUE) {
      return first_max;
    } else {
      return (int) third_max;
    }
  }
}