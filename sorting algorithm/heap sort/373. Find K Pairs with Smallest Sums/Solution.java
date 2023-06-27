class Solution {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    int m = nums1.length;
    int n = nums2.length;
    List<List<Integer>> res = new ArrayList<>();
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
    Set<Pair<Integer, Integer>> visited = new HashSet<>();

    pq.offer(new int[] { nums1[0] + nums2[0], 0, 0 });
    visited.add(new Pair<Integer, Integer>(0, 0));

    while (k > 0 && !pq.isEmpty()) {
      int[] cur = pq.poll();
      int i = cur[1];
      int j = cur[2];

      res.add(Arrays.asList(nums1[i], nums2[j]));

      if (i + 1 < m && !visited.contains(new Pair<Integer, Integer>(i + 1, j))) {
        pq.offer(new int[] { nums1[i + 1] + nums2[j], i + 1, j });
        visited.add(new Pair<Integer, Integer>(i + 1, j));
      }

      if (j + 1 < n && !visited.contains(new Pair<Integer, Integer>(i, j + 1))) {
        pq.offer(new int[] { nums1[i] + nums2[j + 1], i, j + 1 });
        visited.add(new Pair<Integer, Integer>(i, j + 1));
      }

      k--;
    }
    return res;
  }
}