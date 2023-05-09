// TC = O(nlogk), SC = O(n+k)
class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    if (k == nums.length)
      return nums;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
    for (int num : map.keySet()) {
      pq.add(num);
      if (pq.size() > k)
        pq.poll();
    }

    int[] res = new int[k];
    for (int i = k - 1; i >= 0; i--) {
      res[i] = pq.poll();
    }
    return res;
  }
}