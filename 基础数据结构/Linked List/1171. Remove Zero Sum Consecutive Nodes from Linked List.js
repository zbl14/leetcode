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
var removeZeroSumSublists = function (head) {
  let preFix = 0;
  let dummy = new ListNode();
  dummy.next = head;
  const map = new Map();
  map.set(0, dummy);
  for (let i = dummy; i !== null; i = i.next) {
    preFix += i.val;
    map.set(preFix, i);
  }
  preFix = 0;
  for (let i = dummy; i !== null; i = i.next) {
    preFix += i.val;
    i.next = map.get(preFix).next;
  }
  return dummy.next;
};
