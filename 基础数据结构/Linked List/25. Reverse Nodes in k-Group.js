/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function (head, k) {
  let listLength = countLength(head);
  let i = 1;
  while (i + k - 1 <= listLength) {
    head = reverseBetween(head, i, i + k - 1);
    i += k;
  }
  return head;
};

const reverseBetween = (head, left, right) => {
  let dummyHead = new ListNode();
  dummyHead.next = head;
  let prev = dummyHead;
  let cur = dummyHead.next;
  let i = 1;
  while (i < left) {
    prev = cur;
    cur = cur.next;
    i++;
  }
  let node = prev;
  while (i <= right) {
    let next = cur.next;
    cur.next = prev;
    prev = cur;
    cur = next;
    i++;
  }
  node.next.next = cur;
  node.next = prev;
  return dummyHead.next;
};

const countLength = (cur) => {
  let count = 0;
  while (cur) {
    cur = cur.next;
    count++;
  }
  return count;
};
