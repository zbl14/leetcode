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
    if (idx >= candidates.length || total > target) {
      return;
    }
    temp.add(candidates[idx]);
    backtracking(idx, temp, total + candidates[idx], candidates, target, res);
    temp.remove(temp.size() - 1);
    backtracking(idx + 1, temp, total, candidates, target, res);
  }
}
