import java.util.HashSet;

// 1062. Longest Repeating Substring;

class Solution {
  public int longestRepeatingSubstring(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (isValid(mid, s)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return right;
  }

  private boolean isValid(int len, String s) {
    HashSet<String> seen = new HashSet<>();
    for (int i = 0; i < s.length() - len + 1; i++) {
      String subStr = s.substring(i, i + len);
      if (seen.contains(subStr))
        return true;
      else
        seen.add(subStr);
    }
    return false;
  }
}
