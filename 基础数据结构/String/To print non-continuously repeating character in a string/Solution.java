// To print non-continuously repeating character in a string in java

// Input: aabbccdde   
// Output: e
// Input: aeea  
// Output: aa
// Input: ddaeea  
// Output: aa

import java.lang.StringBuilder;

public class Solution {
  public static void main(String[] args) {
    System.out.println("output: " + nonContinuousCharacters("aabbccdde"));
    System.out.println("output: " + nonContinuousCharacters("aeea"));
    System.out.println("output: " + nonContinuousCharacters("ddaeea"));
    System.out.println("output: " + nonContinuousCharacters(""));
  }

  public static String nonContinuousCharacters(String str) {
    // If the input string is empty or null, we return an empty string
    if (str == null || str.isEmpty()) {
      return "";
    }

    StringBuilder result = new StringBuilder();
    char lastChar = str.charAt(0);
    int count = 1;

    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == lastChar) {
        count++;
      } else {
        if (count == 1) {
          result.append(lastChar);
        }
        count = 1;
        lastChar = str.charAt(i);
      }
    }

    // Handle the last character
    if (count == 1) {
      result.append(lastChar);
    }

    return result.toString();
  }
}
