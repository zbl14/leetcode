class Node {
  public int val;
  public List<Node> children;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }
};

// dfs top down
class Solution {
  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    int maxDepth = 0;
    for (Node child : root.children) {
      int childDepth = maxDepth(child);
      maxDepth = Math.max(maxDepth, childDepth);
    }
    return maxDepth + 1;
  }
}

// bfs
// class Solution {
// public int maxDepth(Node root) {
// int res = 0;
// Queue<Node> q = new LinkedList<>();
// if (root != null)
// q.offer(root);
// while (!q.isEmpty()) {
// int size = q.size();
// List<Integer> level = new ArrayList<>();
// res++;
// for (int i = 0; i < size; i++) {
// Node cur = q.poll();
// level.add(cur.val);
// for (Node child : cur.children) {
// if (child != null)
// q.offer(child);
// }
// }
// }
// return res;
// }
// }