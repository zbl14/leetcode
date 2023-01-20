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
  let stack1 = [];
  let stack2 = [];
  while (l1) {
    stack1.push(l1.val);
    l1 = l1.next;
  }
  while (l2) {
    stack2.push(l2.val);
    l2 = l2.next;
  }
  let res = null;
  let carry = 0;
  while (stack1.length || stack2.length || carry !== 0) {
    let val1 = stack1.length ? stack1.pop() : 0;
    let val2 = stack2.length ? stack2.pop() : 0;
    let sum = val1 + val2 + carry;
    let cur = new ListNode(sum % 10);
    carry = Math.floor(sum / 10);
    cur.next = res;
    res = cur;
  }
  return res;
};
