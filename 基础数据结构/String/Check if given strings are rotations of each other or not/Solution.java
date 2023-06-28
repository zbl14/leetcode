// Check if given strings are rotations of each other or not

// Input: S1 = ABCD, S2 = CDAB
// Output: Strings are rotations of each other

// Input: S1 = ABCD, S2 = ACBD
// Output: Strings are not rotations of each other

import java.util.ArrayList;
import java.util.List;

class Solution {
  public static void main(String[] args) {
    String s1 = "ABCD", s2 = "CDAB";
    String s3 = "ABACD", s4 = "ACDAB";
    String s5 = "ABACD", s6 = "ACADB";

    System.out.println(isRotation(s1, s2));
    System.out.println(isRotation(s3, s4));
    System.out.println(isRotation(s5, s6));

  }

  static boolean isRotation(String s1, String s2) {
    if (s1.length() != s2.length())
      return false;

    List<Integer> indexes = new ArrayList<>();

    char firstChar = s1.charAt(0);

    for (int i = 0; i < s1.length(); i++) {
      if (s2.charAt(i) == firstChar) {
        indexes.add(i);
      }
    }

    for (int idx : indexes) {
      if (isValid(s1, s2, idx))
        return true;
    }

    return false;
  }

  static boolean isValid(String s1, String s2, int idx) {
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt((idx + i) % s1.length())) {
        return false;
      }
    }
    return true;
  }
}