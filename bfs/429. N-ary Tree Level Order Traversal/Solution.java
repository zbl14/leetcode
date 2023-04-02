import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a Node.
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

class Solution {
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> res = new ArrayList<>();
    Queue<Node> q = new LinkedList<>();
    if (root != null)
      q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        Node cur = q.poll();
        level.add(cur.val);
        for (int j = 0; j < cur.children.size(); j++) {
          if (cur.children.get(j) != null)
            q.offer(cur.children.get(j));
        }
      }
      res.add(level);
    }
    return res;
  }
}