class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(candidates, target, 0, 0, new ArrayList<>(), res);
    return res;
  }

  private void backtrack(int[] candidates, int target, int sum, int idx, List<Integer> tmp, List<List<Integer>> res) {
    if (sum == target) {
      res.add(new ArrayList<>(tmp));
      return;
    }
    for (int i = idx; i < candidates.length; i++) {
      if (sum > target)
        break;
      if (i > idx && candidates[i] == candidates[i - 1])
        continue;
      tmp.add(candidates[i]);
      backtrack(candidates, target, sum + candidates[i], i + 1, tmp, res);
      tmp.remove(tmp.size() - 1);
    }
  }
}