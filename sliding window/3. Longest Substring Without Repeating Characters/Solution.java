class Solution {
  public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int l = 0, res = 0;
    for (int r = 0; r < s.length(); r++) {
      char c = s.charAt(r);
      while (!set.add(c)) {
        set.remove(s.charAt(l));
        l++;
      }
      res = Math.max(res, r - l + 1);
    }
    return res;
  }
}

// class Solution {
// public int lengthOfLongestSubstring(String s) {
// Set<Character> set = new HashSet<>();
// int l = 0, res = 0;
// for (int r = 0; r < s.length(); r++) {
// char c = s.charAt(r);
// while (set.contains(c)) {
// set.remove(s.charAt(l));
// l++;
// }
// set.add(c);
// res = Math.max(res, r - l + 1);
// }
// return res;
// }
// }