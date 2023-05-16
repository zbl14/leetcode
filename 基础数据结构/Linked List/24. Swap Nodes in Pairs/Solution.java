class Solution {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;

    while (head != null && head.next != null) {
      ListNode first = head;
      ListNode second = head.next;

      first.next = second.next;
      second.next = first;
      prev.next = second;

      prev = first;
      head = first.next;
    }
    return dummy.next;
  }
}

// dummy -> 1 -> 2 -> 3 -> 4 -> null

// first while loop
// first.next = second.next; // 1 -> 3
// second.next = first; // 2 -> 1

// dummy -> 1 -> 3 -> 4 -> null
// 2 -> 1 -> 3 -> 4 -> null

// prev.next = second; // dummy -> 2
// dummy -> 2 -> 1 -> 3 -> 4 -> null

// prev = first; // prev -> 1
// head = first.next; // head -> 3

// second while loop
// first.next = second.next; // 3 -> null
// second.next = first; // 4 -> 3
// prev.next = second; // 1 -> 4

// dummy -> 2 -> 1 -> 4 -> 3 -> null

// prev = first; // prev -> 3
// head = first.next; // head -> null
// At this point, head is null, so the while loop ends, return dummy.next
