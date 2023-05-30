class Solution {
  public String getHint(String secret, String guess) {
    int[] h = new int[10];
    int bulls = 0;
    int cows = 0;
    int n = secret.length();
    for (int i = 0; i < n; i++) {
      char s = secret.charAt(i);
      char g = guess.charAt(i);
      if (s == g) {
        bulls++;
      } else {
        if (h[s - '0'] < 0)
          cows++;
        if (h[g - '0'] > 0)
          cows++;
        h[s - '0']++;
        h[g - '0']--;
      }
    }
    StringBuilder sb = new StringBuilder();
    sb.append(bulls).append("A").append(cows).append("B");
    return sb.toString();
  }
}