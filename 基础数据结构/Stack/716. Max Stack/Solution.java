import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

// The time complexity of the push(), pop(), top(), and peekMax()
// methods is O(1) since they only involve operations on the top element of the
// stack.
// popMax() method has a worst-case time complexity of O(n)

// class MaxStack {
// private Stack<int[]> stack;

// public MaxStack() {
// stack = new Stack<>();
// }

// public void push(int x) {
// int max = x;
// if (!stack.isEmpty()) {
// max = Math.max(stack.peek()[1], x);
// }
// stack.push(new int[] { x, max });
// }

// public int pop() {
// if (!stack.isEmpty()) {
// return stack.pop()[0];
// }
// return -1;
// }

// public int top() {
// return stack.peek()[0];
// }

// public int peekMax() {
// return stack.peek()[1];
// }

// public int popMax() {
// Stack<int[]> tempStack = new Stack<>();
// int max = stack.peek()[1];
// while (stack.peek()[0] != max) {
// tempStack.push(stack.pop());
// }
// int ans = stack.pop()[1];
// while (!tempStack.isEmpty()) {
// push(tempStack.pop()[0]);
// }
// return ans;
// }
// }

class MaxStack {
  private Stack<int[]> stack;
  private Queue<int[]> heap;
  private Set<Integer> removed;
  private int cnt;

  public MaxStack() {
    stack = new Stack<>();
    heap = new PriorityQueue<>((a, b) -> b[0] == a[0] ? b[1] - a[1] : b[0] - a[0]);
    removed = new HashSet<>();
  }

  public void push(int x) {
    stack.add(new int[] { x, cnt });
    heap.add(new int[] { x, cnt });
    cnt++;
  }

  public int pop() {
    while (removed.contains(stack.peek()[1])) {
      stack.pop();
    }
    int[] top = stack.pop();
    removed.add(top[1]);
    return top[0];
  }

  public int top() {
    while (removed.contains(stack.peek()[1])) {
      stack.pop();
    }
    return stack.peek()[0];
  }

  public int peekMax() {
    while (removed.contains(heap.peek()[1])) {
      heap.poll();
    }
    return heap.peek()[0];

  }

  public int popMax() {
    while (removed.contains(heap.peek()[1])) {
      heap.poll();
    }
    int[] top = heap.poll();
    removed.add(top[1]);
    return top[0];
  }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */