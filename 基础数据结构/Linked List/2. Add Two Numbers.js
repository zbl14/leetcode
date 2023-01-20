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
  let carry = 0;
  let dummy = new ListNode();
  let cur = dummy; // cur = 0
  while (l1 || l2) {
    // l1 = 2->4->7, l2 = 5->6->4
    let sum = carry; // sum = 0      sum = 0      sum = 1
    if (l1) {
      sum += l1.val; //sum = 2     sum = 4     sum = 8
      l1 = l1.next; // l1 = 4->7  l1 = 7      l1 = null
    }
    if (l2) {
      sum += l2.val; // sum=7       sum =10     sum = 12
      l2 = l2.next; // l2 = 6->4   l2 = 4      l2 = null
    }
    cur.next = new ListNode(sum % 10); // cur.next = 7   cur.next = 0  cur.next = 2
    cur = cur.next; // cur = 7       cur = 0      cur = 2
    carry = Math.floor(sum / 10); // carry = 0     carry = 1    carry = 1
  }
  if (carry > 0) cur.next = new ListNode(carry); // ****     *****   cur = 2, cur.next = carry = 1, 2 -> 1
  return dummy.next; // 7->0->2->1
};
