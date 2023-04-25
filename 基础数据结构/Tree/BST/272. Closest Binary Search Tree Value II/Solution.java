class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  };

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

// TC = O(nlog(k)), SC = O(n+k)
class Solution {
  private PriorityQueue<Pair<Integer, Double>> pq;

  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    pq = new PriorityQueue<Pair<Integer, Double>>((a, b) -> Double.compare(b.getValue(), a.getValue()));
    List<Integer> res = new ArrayList<>();

    helper(root, target, k);

    while (!pq.isEmpty()) {
      res.add(pq.poll().getKey());
    }
    return res;
  }

  private void helper(TreeNode root, double target, int k) {
    if (root == null)
      return;
    helper(root.left, target, k);
    Pair<Integer, Double> pair = new Pair<>(root.val, Math.abs(root.val - target));
    pq.offer(pair);
    while (pq.size() > k)
      pq.poll();
    helper(root.right, target, k);
  }
}
