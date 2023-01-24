/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
// TC = O(m+n), SC = O(1)
var getIntersectionNode = function (headA, headB) {
  let lenA = getLength(headA);
  let lenB = getLength(headB);
  while (lenA < lenB) {
    headB = headB.next;
    lenB--;
  }
  while (lenA > lenB) {
    headA = headA.next;
    lenA--;
  }
  while (headA && headB) {
    if (headA === headB) return headA;
    headA = headA.next;
    headB = headB.next;
  }
  return null;
};

const getLength = (list) => {
  let length = 0;
  while (list) {
    length++;
    list = list.next;
  }
  return length;
};
