class Solution {
  public int longestPalindrome(String[] words) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    int count1 = 0;
    int count2 = 0;
    int hasXX = 0;

    // Create a copy of the keys to avoid ConcurrentModificationException
    Set<String> keys = new HashSet<>(map.keySet());

    for (String key : keys) {
      if (key.charAt(0) == key.charAt(1)) {
        if (map.get(key) % 2 == 1)
          hasXX = 1;
        count1 += map.get(key) / 2;
      } else {
        String reversedKey = "" + key.charAt(1) + key.charAt(0);
        if (map.containsKey(key) && map.containsKey(reversedKey)) {
          count2 += Math.min(map.get(key), map.get(reversedKey));
        }
        map.remove(key);
        map.remove(reversedKey);
      }
    }

    return count1 * 2 * 2 + count2 * 2 * 2 + hasXX * 2;
  }
}