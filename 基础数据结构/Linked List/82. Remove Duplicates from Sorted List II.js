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
var deleteDuplicates = function (head) {
  let dummy = new ListNode();
  dummy.next = head;
  let prev = dummy;
  let cur = head;
  while (cur && cur.next) {
    if (cur.val === cur.next.val) {
      let temp = cur.val;
      while (cur && temp === cur.val) cur = cur.next;
      prev.next = cur;
    } else {
      prev = prev.next;
      cur = cur.next;
    }
  }
  return dummy.next;
};
