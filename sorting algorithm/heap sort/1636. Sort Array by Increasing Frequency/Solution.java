class Solution {
  public int[] frequencySort(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
    for (int key : map.keySet())
      pq.offer(new int[] { key, map.get(key) });
    int[] res = new int[nums.length];
    int idx = 0;
    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      for (int i = 0; i < cur[1]; i++) {
        res[idx] = cur[0];
        idx++;
      }
    }
    return res;
  }
}