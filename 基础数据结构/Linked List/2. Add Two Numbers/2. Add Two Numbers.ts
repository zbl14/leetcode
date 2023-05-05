class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function addTwoNumbers(
  l1: ListNode | null,
  l2: ListNode | null
): ListNode | null {
  let carry: number = 0;
  let dummy: ListNode | null = new ListNode();
  let cur = dummy;
  while (l1 !== null || l2 !== null) {
    let sum: number = carry;
    if (l1 !== null) {
      sum += l1.val;
      l1 = l1.next;
    }
    if (l2 !== null) {
      sum += l2.val;
      l2 = l2.next;
    }
    cur.next = new ListNode(sum % 10);
    cur = cur.next;
    carry = Math.floor(sum / 10);
  }
  if (carry > 0) cur.next = new ListNode(carry);
  return dummy.next;
}
