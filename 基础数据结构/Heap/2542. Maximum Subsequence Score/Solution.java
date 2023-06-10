class Solution {
  public long maxScore(int[] nums1, int[] nums2, int k) {
    int[][] pairs = new int[nums1.length][2];
    for (int i = 0; i < nums1.length; i++) {
      pairs[i] = new int[] { nums1[i], nums2[i] };
    }
    Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    long topKSum = 0;
    for (int i = 0; i < k; i++) {
      topKSum += pairs[i][0];
      pq.add(pairs[i][0]);
    }

    long res = topKSum * pairs[k - 1][1];

    for (int i = k; i < nums1.length; i++) {
      topKSum += pairs[i][0] - pq.poll();
      pq.add(pairs[i][0]);
      res = Math.max(res, topKSum * pairs[i][1]);
    }

    return res;
  }
}