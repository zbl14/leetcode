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
var sortList = function (head) {
  if (!head || !head.next) return head;
  let mid = findMid(head); //快慢指针找中点
  const right = sortList(mid.next); //分割两半
  mid.next = null;
  const left = sortList(head);
  return merge(left, right);
};

const findMid = (list) => {
  let slow = list;
  let fast = list;
  while (fast.next !== null && fast.next.next !== null) {
    slow = slow.next;
    fast = fast.next.next;
  }
  return slow;
};

const merge = (list1, list2) => {
  let dummyHead = new ListNode();
  let cur = dummyHead;
  while (list1 && list2) {
    if (list1.val < list2.val) {
      cur.next = list1;
      list1 = list1.next;
    } else {
      cur.next = list2;
      list2 = list2.next;
    }
    cur = cur.next;
  }
  cur.next = list1 || list2;
  return dummyHead.next;
};
