class Solution {
  private List<String> res = new ArrayList<>();
  private Map<Character, String> btns = Map.of(
      '2', "abc",
      '3', "def",
      '4', "ghi",
      '5', "jkl",
      '6', "mno",
      '7', "pqrs",
      '8', "tuv",
      '9', "wxyz");

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0)
      return res;
    backtrack(0, new StringBuilder(), digits);
    return res;
  }

  private void backtrack(int idx, StringBuilder tmp, String digits) {
    if (tmp.length() == digits.length()) {
      res.add(tmp.toString());
      return;
    }
    String possibleLetters = btns.get(digits.charAt(idx));
    for (char letter : possibleLetters.toCharArray()) {
      tmp.append(letter);
      backtrack(idx + 1, tmp, digits);
      tmp.deleteCharAt(tmp.length() - 1);
    }
  }
}