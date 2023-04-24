class Solution {
  public int lengthOfLIS(int[] nums) {
    List<Integer> sub = new ArrayList<>();
    sub.add(nums[0]);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > sub.get(sub.size() - 1)) {
        sub.add(nums[i]);
      } else {
        int idx = binarySearch(sub, nums[i]);
        sub.set(idx, nums[i]);
      }
    }
    return sub.size();
  }

  private int binarySearch(List<Integer> sub, int target) {
    int l = 0;
    int r = sub.size() - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (sub.get(mid) == target)
        return mid;
      else if (sub.get(mid) < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return l;
  }
}
