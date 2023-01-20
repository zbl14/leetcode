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
  return partition(lists, 0, lists.length - 1);
};

const partition = (lists, start, end) => {
  if (start === end) return lists[start];
  while (start < end) {
    let mid = start + ((end - start) >> 1);
    const list1 = partition(lists, start, mid);
    const list2 = partition(lists, mid + 1, end);
    return merge(list1, list2);
  }
  return null;
};

const merge = (l1, l2) => {
  if (!l1) return l2;
  if (!l2) return l1;
  if (l1.val < l2.val) {
    l1.next = merge(l1.next, l2);
    return l1;
  } else {
    l2.next = merge(l1, l2.next);
    return l2;
  }
};
