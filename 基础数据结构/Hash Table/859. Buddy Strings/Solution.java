class Solution {
  public static void main(String[] args) {
    String s = "ab";
    String goal = "ba";

    String s1 = "ab";
    String goal1 = "ab";

    Solution solution = new Solution();
    System.out.println(solution.buddyStrings(s, goal));
    System.out.println(solution.buddyStrings(s1, goal1));
  }

  public boolean buddyStrings(String s, String goal) {
    if (s.length() != goal.length()) {
      return false;
    }

    if (s.equals(goal)) {
      int[] frequency = new int[26];
      for (char c : s.toCharArray()) {
        frequency[c - 'a']++;
        if (frequency[c - 'a'] == 2) {
          return true;
        }
      }
      return false;
    }

    int firstIdx = -1;
    int secondIdx = -1;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != goal.charAt(i)) {
        if (firstIdx == -1) {
          firstIdx = i;
        } else if (secondIdx == -1) {
          secondIdx = i;
        } else {
          return false;
        }
      }
    }
    if (secondIdx == -1) {
      return false;
    }

    return s.charAt(firstIdx) == goal.charAt(secondIdx) && s.charAt(secondIdx) == goal.charAt(firstIdx);
  }
}