import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean wordPattern(String pattern, String s) {
    Map<Character, String> charToWord = new HashMap<>();
    Map<String, Character> wordToChar = new HashMap<>();
    String[] words = s.split(" ");
    if (pattern.length() != words.length) {
      return false;
    }

    for (int i = 0; i < words.length; i++) {
      char c = pattern.charAt(i);
      String w = words[i];

      if (!charToWord.containsKey(c) && !wordToChar.containsKey(w)) {
        charToWord.put(c, w);
        wordToChar.put(w, c);
      } else if (!charToWord.containsKey(c) || !wordToChar.containsKey(w) || !charToWord.get(c).equals(w)
          || wordToChar.get(w) != c) {
        return false;
      }
    }
    return true;
  }
}