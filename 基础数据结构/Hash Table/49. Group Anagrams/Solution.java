// TC = O(n * k * log(k)), SC = O(n * k)
// where n is the length of the input array strs, 
// and k is the maximum length of a string in strs.
class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null)
      return Collections.emptyList();

    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] arr = str.toCharArray();
      Arrays.sort(arr);
      String sortedWord = new String(arr);
      map.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(str);
    }
    return new ArrayList<>(map.values());
  }
}