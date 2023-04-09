class Solution {
  public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    backtrack(res, new ArrayList<>(), s, 0);
    return res;
  }

  private void backtrack(List<List<String>> res, List<String> temp, String s, int start) {
    if (start >= s.length())
      res.add(new ArrayList<>(temp));
    for (int end = start; end < s.length(); end++) {
      if (isPalindrome(s, start, end)) {
        temp.add(s.substring(start, end + 1));
        backtrack(res, temp, s, end + 1);
        temp.remove(temp.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left++) != s.charAt(right--))
        return false;
    }
    return true;
  }
}