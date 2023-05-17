/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// TC = O(n), SC = O(n)
// class Solution {
// public int pairSum(ListNode head) {
// Map<Integer, Integer> map = new HashMap<>();
// int i = 0;
// while(head != null){
// map.put(i, head.val);
// head = head.next;
// i++;
// }
// int l = 0;
// int r = i - 1;
// int res = 0;
// while(l < r){
// res = Math.max(res, map.get(l) + map.get(r));
// l++;
// r--;
// }
// return res;
// }
// }

class Solution {
  public int pairSum(ListNode head) {
    ListNode current = head;
    List<Integer> values = new ArrayList<>();

    while (current != null) {
      values.add(current.val);
      current = current.next;
    }

    int i = 0, j = values.size() - 1;
    int maximumSum = 0;
    while (i < j) {
      maximumSum = Math.max(maximumSum, values.get(i) + values.get(j));
      i++;
      j--;
    }

    return maximumSum;
  }
}