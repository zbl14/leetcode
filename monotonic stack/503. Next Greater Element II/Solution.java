import java.util.Stack;

class Solution {
  public int[] nextGreaterElements(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int n = nums.length;
    int[] res = new int[n];
    for (int i = 2 * n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && nums[i % n] >= stack.peek())
        stack.pop();
      res[i % n] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(nums[i % n]);
    }
    return res;
  }
}