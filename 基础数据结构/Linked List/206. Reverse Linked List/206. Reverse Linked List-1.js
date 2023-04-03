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
//iterative
var reverseList = function (head) {
  let newHead = null;
  let cur = head;
  while (cur) {
    let temp = cur.next;
    cur.next = newHead;
    newHead = cur;
    cur = temp;
  }
  return newHead;
};
