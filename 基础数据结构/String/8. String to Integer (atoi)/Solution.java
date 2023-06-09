class Solution {
  public int myAtoi(String s) {
    int sign = 1;
    int res = 0;
    int idx = 0;
    int n = s.length();

    while (idx < n && s.charAt(idx) == ' ') {
      idx++;
    }

    if (idx < n && s.charAt(idx) == '+') {
      idx++;
    } else if (idx < n && s.charAt(idx) == '-') {
      sign = -1;
      idx++;
    }

    while (idx < n && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
      int digit = s.charAt(idx) - '0';

      if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }

      res = 10 * res + digit;
      idx++;
    }

    return sign * res;
  }
}