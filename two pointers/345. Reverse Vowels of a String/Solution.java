class Solution {
  public String reverseVowels(String s) {
    Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    int l = 0;
    int r = s.length() - 1;
    char[] c = s.toCharArray();
    while (l < r) {
      while (l < r && !set.contains(c[l])) {
        l++;
      }
      while (l < r && !set.contains(c[r])) {
        r--;
      }
      if (l < r) {
        char temp = c[l];
        c[l++] = c[r];
        c[r--] = temp;
      }
    }
    return String.valueOf(c);
  }
}