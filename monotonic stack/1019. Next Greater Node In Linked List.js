/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {number[]}
 */

//496套娃，将linked list转化成array
var nextLargerNodes = function (head) {
  const numArr = [];
  for (let cur = head; cur !== null; cur = cur.next) numArr.push(cur.val);
  const stack = [];
  const res = [];
  for (let i = numArr.length - 1; i >= 0; i--) {
    while (stack.length && numArr[i] >= stack[stack.length - 1]) stack.pop();
    res[i] = stack.length ? stack[stack.length - 1] : 0;
    stack.push(numArr[i]);
  }
  return res;
};
