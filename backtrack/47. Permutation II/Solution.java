import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
    return res;
  }

  private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
    if (temp.size() == nums.length)
      res.add(new ArrayList<>(temp));
    for (int i = 0; i < nums.length; i++) {
      if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
        continue;
      used[i] = true;
      temp.add(nums[i]);
      backtrack(res, temp, nums, used);
      used[i] = false;
      temp.remove(temp.size() - 1);
    }
  }
}