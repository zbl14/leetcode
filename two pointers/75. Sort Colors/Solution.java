// Two pointer, one pass, TC = O(n), SC = O(n)
class Solution {
  public void sortColors(int[] nums) {
    int l = 0;
    int r = nums.length - 1;
    for (int i = 0; i <= r; i++) {
      if (nums[i] == 0 && i > l)
        swap(nums, i--, l++);
      else if (nums[i] == 2 && i < r)
        swap(nums, i--, r--);
    }
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}

// Counting sort, TC = O(n), SC = O(n)
// class Solution {
// public void sortColors(int[] nums) {
// int cntZero = 0;
// int cntOne = 0;
// for (int num : nums) {
// if (num == 0)
// cntZero++;
// if (num == 1)
// cntOne++;
// if (num == 2)
// cntTwo++;
// }
// for (int i = 0; i < nums.length; i++) {
// if (cntZero > 0) {
// nums[i] = 0;
// cntZero--;
// } else if (cntOne > 0) {
// nums[i] = 1;
// cntOne--;
// } else {
// nums[i] = 2;
// }
// }
// }
// }