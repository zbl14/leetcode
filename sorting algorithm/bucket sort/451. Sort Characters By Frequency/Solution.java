class Solution {
  public String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();
    char[] chars = s.toCharArray();
    for (char c : chars) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
    for (Character c : map.keySet()) {
      pq.offer(c);
    }
    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      char c = pq.poll();
      for (int i = 0; i < map.get(c); i++) {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}