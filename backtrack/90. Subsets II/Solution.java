import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(res, new ArrayList<>(), nums, 0);
    return res;
  }

  private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int idx) {
    res.add(new ArrayList<>(temp));
    for (int i = idx; i < nums.length; i++) {
      if (i > idx && nums[i] == nums[i - 1])
        continue;
      temp.add(nums[i]);
      backtrack(res, temp, nums, i + 1);
      temp.remove(temp.size() - 1);
    }
  }
}