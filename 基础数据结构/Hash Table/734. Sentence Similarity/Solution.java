class Solution {
  public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
    if (sentence1.length != sentence2.length) {
      return false;
    }
    Map<String, Set<String>> map = new HashMap<>();
    for (List<String> pair : similarPairs) {
      map.computeIfAbsent(pair.get(0), k -> new HashSet<String>()).add(pair.get(1));
      map.computeIfAbsent(pair.get(1), k -> new HashSet<String>()).add(pair.get(0));
    }

    for (int i = 0; i < sentence1.length; i++) {
      if (sentence1[i].equals(sentence2[i])) {
        continue;
      } else if (map.containsKey(sentence1[i]) && map.get(sentence1[i]).contains(sentence2[i])) {
        continue;
      } else {
        return false;
      }
    }
    return true;
  }
}
