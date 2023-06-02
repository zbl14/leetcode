class Solution {
  private Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

  public int maxVowels(String s, int k) {
    int res = 0;
    int l = 0;
    int cnt = 0;
    for (int r = 0; r < s.length(); r++) {
      cnt += set.contains(s.charAt(r)) ? 1 : 0;
      while (r - l + 1 > k) {
        cnt -= set.contains(s.charAt(l)) ? 1 : 0;
        l++;
      }
      res = Math.max(res, cnt);
    }
    return res;
  }
}
