const reverseList = (list) => {
  let prev = null;
  while (list !== null) {
    let next = list.next;
    list.next = prev;
    prev = list;
    list = next;
  }
  return prev;
};

const findMid = (list) => {
  let fast = list;
  let slow = list;
  while (fast.next !== null && fast.next.next !== null) {
    fast = fast.next.next;
    slow = slow.next;
  }
  return slow;
};
