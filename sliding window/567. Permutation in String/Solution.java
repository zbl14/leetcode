class Solution {
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length())
      return false;

    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s1.length(); i++) {
      char c = s1.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    int l = 0;
    int match = 0;
    for (int r = 0; r < s2.length(); r++) {
      char c = s2.charAt(r);
      if (!map.containsKey(c))
        continue;

      int cnt = map.get(c);
      map.put(c, cnt - 1);

      if (cnt == 1) {
        match++;
      }

      while (match == map.size()) {
        if (r - l + 1 == s1.length())
          return true;

        char pre = s2.charAt(l);
        l++;

        if (!map.containsKey(pre))
          continue;

        int preCnt = map.get(pre);
        map.put(pre, preCnt + 1);

        if (preCnt == 0) {
          match--;
        }
      }
    }
    return false;
  }
}