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
// TC = O(n), SC = O(n)
var isPalindrome = function (head) {
  let cur = head;
  let arr = [];
  while (cur) {
    arr.push(cur.val);
    cur = cur.next;
  }
  for (let i = 0; i < arr.length >> 1; i++) {
    if (arr[i] !== arr[arr.length - 1 - i]) return false;
  }
  return true;
};
