/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
//recursive
var reverseList = function (head) {
  return reverse(head, null);
};

const reverse = (head, newHead) => {
  if (!head) return newHead;
  let next = head.next;
  head.next = newHead;
  return reverse(next, head);
};
