
class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}

class Solution {
  public Node cloneGraph(Node node) {
    Map<Node, Node> map = new HashMap<>();
    Queue<Node> q = new LinkedList<>();
    if (node != null) {
      q.offer(node);
      map.put(node, new Node(node.val, new ArrayList()));
    }
    while (!q.isEmpty()) {
      Node cur = q.poll();
      for (Node nei : cur.neighbors) {
        if (!map.containsKey(nei)) {
          map.put(nei, new Node(nei.val, new ArrayList<>()));
          q.offer(nei);
        }
        map.get(cur).neighbors.add(map.get(nei));
      }
    }
    return map.get(node);
  }
}
