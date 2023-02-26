/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {void} Do not return anything, modify head in-place instead.
 */
var reorderList = function (head) {
  const stack = [];
  let secondHaft = findMid(head);
  while (secondHaft) {
    stack.push(secondHaft);
    secondHaft = secondHaft.next;
  }
  let dummy = new ListNode();
  let cur = dummy;
  while (stack.length > 0) {
    cur.next = head;
    head = head.next;
    cur = cur.next;
    cur.next = stack.pop();
    cur = cur.next;
  }
  cur.next = null;
  return dummy.next;
};

const findMid = (list) => {
  let slow = list;
  let fast = list;
  while (slow && fast && fast.next) {
    slow = slow.next;
    fast = fast.next.next;
  }
  return slow;
};
pass;
