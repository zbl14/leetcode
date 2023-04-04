import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    backtracking(0, new ArrayList<>(), 0, candidates, target, res);
    return res;
  }

  private void backtracking(int idx, List<Integer> temp, int total, int[] candidates, int target,
      List<List<Integer>> res) {
    if (total == target) {
      res.add(new ArrayList<>(temp));
      return;
    }
    if (total > target) {
      return;
    }
    for (int i = idx; i < candidates.length; i++) {
      temp.add(candidates[i]);
      backtracking(i, temp, total + candidates[i], candidates, target, res);
      temp.remove(temp.size() - 1);
    }
  }
}
