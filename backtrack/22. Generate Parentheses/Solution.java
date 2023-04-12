// class Solution {
//   public List<String> generateParenthesis(int n) {
//     List<String> res = new ArrayList<>();
//     backtrack(n, n, "", res);
//     return res;
//   }

//   private void backtrack(int l, int r, String temp, List<String> res) {
//     if (l == 0 && r == 0)
//       res.add(new String(temp));
//     if (l > 0) {
//       backtrack(l - 1, r, temp + "(", res);
//     }
//     if (l < r)
//       backtrack(l, r - 1, temp + ")", res);
//   }
// }

class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    backtrack(n, n, new StringBuilder(), res);
    return res;
  }

  private void backtrack(int l, int r, StringBuilder temp, List<String> res) {
    if (l == 0 && r == 0)
      res.add(temp.toString());
    if (l > 0) {
      temp.append("(");
      backtrack(l - 1, r, temp, res);
      temp.deleteCharAt(temp.length() - 1);
    }
    if (l < r) {
      temp.append(")");
      backtrack(l, r - 1, temp, res);
      temp.deleteCharAt(temp.length() - 1);
    }
  }
}
