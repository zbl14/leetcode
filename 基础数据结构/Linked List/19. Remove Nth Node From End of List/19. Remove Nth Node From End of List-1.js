/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
// two pass
var removeNthFromEnd = function (head, n) {
  let length = 0;
  let first = head;
  while (first) {
    length++;
    first = first.next;
  }
  length -= n;
  let dummy = new ListNode();
  dummy.next = head;
  first = dummy;
  while (length-- > 0) first = first.next;
  first.next = first.next.next;
  return dummy.next;
};
