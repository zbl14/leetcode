// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         List<Integer> res = new ArrayList<>();
//         if (s.length() < p.length() || s.length() == 0) {
//             return res;
//         }

//         Map<Character, Integer> pCnt = new HashMap<>();
//         Map<Character, Integer> sCnt = new HashMap<>();
//         for (char c : p.toCharArray()) {
//             pCnt.put(c, pCnt.getOrDefault(c, 0) + 1);
//         }

//         int l = 0;
//         for (int r = 0; r < s.length(); r++) {
//             char c = s.charAt(r);
//             sCnt.put(c, sCnt.getOrDefault(c, 0) + 1);

//             while (r - l + 1 > p.length()) {
//                 c = s.charAt(l);
//                 if (sCnt.get(c) == 1) {
//                     sCnt.remove(c);
//                 } else {
//                     sCnt.put(c, sCnt.get(c) - 1);
//                 }
//                 l++;
//             }

//             if (pCnt.equals(sCnt)) {
//                 res.add(l);
//             }
//         }
//         return res;
//     }
// }

class Solution {
  public List<Integer> findAnagrams(String s, String p) {

    List<Integer> res = new ArrayList<>();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < p.length(); i++) {
      map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
    }

    int match = 0;
    int l = 0;
    for (int r = 0; r < s.length(); r++) {

      if (!map.containsKey(s.charAt(r)))
        continue;

      int count = map.get(s.charAt(r));
      map.put(s.charAt(r), count - 1);

      if (count == 1) {
        match++;
      }
      while (match == map.size()) {
        if ((r - l + 1) == p.length()) {
          res.add(l);
        }

        char pre = s.charAt(l);
        l++;

        if (!map.containsKey(pre))
          continue;

        int preCount = map.get(pre);
        map.put(pre, preCount + 1);
        if (preCount == 0) {
          match--;
        }
      }
    }
    return res;
  }
}
