/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function (lists) {
  if (!lists.length) return null;
  const arr = [];

  for (let i = 0; i < lists.length; i++) {
    let cur = lists[i];
    while (cur) {
      arr.push(cur.val);
      cur = cur.next;
    }
  }

  let dummy = new ListNode(-1);
  let cur = dummy;
  arr
    .sort((a, b) => a - b)
    .forEach((num) => {
      let temp = new ListNode(num);
      cur.next = temp;
      cur = cur.next;
    });
  return dummy.next;
};
