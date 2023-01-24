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
// TC = O(m+n), SC = O(m+n)
var getIntersectionNode = function (headA, headB) {
  let set = new Set();
  while (headA || headB) {
    if (headA) {
      if (set.has(headA)) return headA;
      set.add(headA);
      headA = headA.next;
    }
    if (headB) {
      if (set.has(headB)) return headB;
      set.add(headB);
      headB = headB.next;
    }
  }
  return null;
};
