
// TC = O(nlog(n))
// class Solution {
//   public List<List<Integer>> getFactors(int n) {
//     if (n <= 3)
//       return new ArrayList<>();
//     List<List<Integer>> res = new ArrayList<>();
//     backtracking(2, new ArrayList<>(), n, res);
//     return res;
//   }

//   private void backtracking(int num, List<Integer> temp, int remain, List<List<Integer>> res) {
//     if (remain == 1 && temp.size() > 1) {
//       res.add(new ArrayList<>(temp));
//       return;
//     }

//     for (int i = num; i <= remain; i++) {
//       if (remain % i != 0) {
//         continue;
//       }
//       temp.add(i);
//       backtracking(i, temp, remain / i, res);
//       temp.remove(temp.size() - 1);
//     }
//   }
// }

class Solution {
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> ans = new ArrayList<>();
    backtracking(new ArrayList<>(Arrays.asList(n)), ans);
    return ans;
  }

  private void backtracking(ArrayList<Integer> factors, List<List<Integer>> ans) {
    if (factors.size() > 1) {
      ans.add(new ArrayList<>(factors));
    }
    int lastFactor = factors.remove(factors.size() - 1);
    for (int i = factors.isEmpty() ? 2 : factors.get(factors.size() - 1); i <= lastFactor / i; ++i) {
      if (lastFactor % i == 0) {
        factors.add(i);
        factors.add(lastFactor / i);
        backtracking(factors, ans);
        factors.remove(factors.size() - 1);
        factors.remove(factors.size() - 1);
      }
    }
    factors.add(lastFactor);
  }
}
