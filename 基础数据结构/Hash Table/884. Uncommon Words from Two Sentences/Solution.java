import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    String s1 = "this apple is sweet";
    String s2 = "this apple is sour";

    String[] strArr = solution.uncommonFromSentences(s1, s2);

    System.out.println(Arrays.toString(strArr));

  }

  public String[] uncommonFromSentences(String s1, String s2) {
    Map<String, Integer> cnt = new HashMap<>();

    for (String s : s1.split(" ")) {
      cnt.put(s, cnt.getOrDefault(s, 0) + 1);
    }
    for (String s : s2.split(" ")) {
      cnt.put(s, cnt.getOrDefault(s, 0) + 1);
    }

    List<String> res = new ArrayList<>();
    for (String s : cnt.keySet()) {
      if (cnt.get(s) == 1) {
        res.add(s);
      }
    }

    return res.toArray(new String[res.size()]);
  }
}