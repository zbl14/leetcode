/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
  l1 = reverse(l1);
  l2 = reverse(l2);
  let carry = 0;
  let dummy = new ListNode();
  let cur = dummy;
  while (l1 || l2) {
    let sum = carry;
    if (l1) {
      sum += l1.val;
      l1 = l1.next;
    }
    if (l2) {
      sum += l2.val;
      l2 = l2.next;
    }
    cur.next = new ListNode(sum % 10);
    cur = cur.next;
    carry = Math.floor(sum / 10);
  }
  if (carry > 0) cur.next = new ListNode(carry);
  return reverse(dummy.next);
};

const reverse = (head) => {
  let prev = null;
  let cur = head;
  while (cur) {
    let next = cur.next;
    cur.next = prev;
    prev = cur;
    cur = next;
  }
  return prev;
};
