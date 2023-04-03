/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// deep copy 题目套路
// 核心 Hash Map
// 1. Copy Node
// HashMap(key -> value), key为旧的，value为新的，只copy value
// 2. Copy ref
// newHead.next = map.get(oriHead.next)
// newHead.random = map.get(orihead.random)

class Solution {
  public Node copyRandomList(Node head) {
    Map<Node, Node> map = new HashMap<>();
    for (Node cur = head; cur != null; cur = cur.next) {
      map.put(cur, new Node(cur.val));
    }
    for (Node cur = head; cur != null; cur = cur.next) {
      map.get(cur).next = map.get(cur.next);
      map.get(cur).random = map.get(cur.random);
    }
    return map.get(head);
  }
}