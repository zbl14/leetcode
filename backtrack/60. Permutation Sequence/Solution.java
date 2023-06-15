class Solution {
  String res;
  int cnt = 0;

  public String getPermutation(int n, int k) {
    backtracking("", n, k, new boolean[n + 1]);
    return res;
  }

  private void backtracking(String temp, int n, int k, boolean[] used) {
    if (temp.length() == n) {
      cnt++;
      if (cnt == k) {
        res = temp;
        return;
      }
    }
    for (int i = 1; i <= n; i++) {
      if (used[i])
        continue;
      used[i] = true;
      backtracking(temp + i, n, k, used);
      used[i] = false;
    }
  }
}