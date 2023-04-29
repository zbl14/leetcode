// TC = O(n), SC = O(n)
// 将树转换成无向图（dfs），通过bfs找最短路径
class Solution {
  public int findClosestLeaf(TreeNode root, int k) {
    Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
    dfs(graph, root, null);

    Queue<TreeNode> q = new LinkedList<>();
    Set<TreeNode> seen = new HashSet<>();
    for (TreeNode node : graph.keySet()) {
      if (node != null && node.val == k) {
        q.offer(node);
        seen.add(node);
      }
    }
    while (!q.isEmpty()) {
      TreeNode cur = q.poll();
      if (cur != null) {
        if (graph.get(cur).size() <= 1)
          return cur.val;
        for (TreeNode nei : graph.get(cur)) {
          if (!seen.contains(nei)) {
            seen.add(nei);
            q.offer(nei);
          }
        }
      }
    }
    return -1;
  }

  private void dfs(Map<TreeNode, List<TreeNode>> graph, TreeNode node, TreeNode parent) {
    if (node != null) {
      graph.computeIfAbsent(node, k -> new LinkedList<TreeNode>());
      graph.computeIfAbsent(parent, k -> new LinkedList<TreeNode>());
      graph.get(node).add(parent);
      graph.get(parent).add(node);
      dfs(graph, node.left, node);
      dfs(graph, node.right, node);
    }
  }
}