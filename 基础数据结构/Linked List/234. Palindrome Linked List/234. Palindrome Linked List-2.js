/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
// TC = O(n), SC = O(1)
var isPalindrome = function (head) {
  if (!head || !head.next) return true;
  let firstHalfEnd = findMid(head);
  let secondHalfStart = reverseList(firstHalfEnd.next);
  let p1 = head;
  let p2 = secondHalfStart;
  let res = true;
  while (res && p2 != null) {
    if (p1.val !== p2.val) res = false;
    p1 = p1.next;
    p2 = p2.next;
  }
  // firstHalfEnd.next = reverseList(secondHalfStart)
  return res;
};

const findMid = (list) => {
  let fast = list;
  let slow = list;
  while (fast.next && fast.next.next) {
    fast = fast.next.next;
    slow = slow.next;
  }
  return slow;
};

const reverseList = (list) => {
  let prev = null;
  let cur = list;
  while (cur) {
    let next = cur.next;
    cur.next = prev;
    prev = cur;
    cur = next;
  }
  return prev;
};
