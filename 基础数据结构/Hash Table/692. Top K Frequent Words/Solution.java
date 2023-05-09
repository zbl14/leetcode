// minHeap, TC = O(nlogk)
class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
      if (map.get(a) == map.get(b)) {
        return b.compareTo(a);
      } else {
        return map.get(a) - map.get(b);
      }
    });
    for (String word : map.keySet()) {
      pq.offer(word);
      if (pq.size() > k) {
        pq.poll();
      }
    }

    List<String> res = new LinkedList<>();
    while (!pq.isEmpty())
      res.add(0, pq.poll());
    return res;
  }
}