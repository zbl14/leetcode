import java.util.Stack;

// class Solution {
//     public int largestRectangleArea(int[] heights) {
//       return calculateArea(heights, 0, heights.length - 1);
//     }

//     private int calculateArea(int[] heights, int start, int end) {
//       if(start>end) return 0;
//       int minHeightIndex = start;
//       for(int i = start; i <=end; i++){
//         if(heights[minHeightIndex] > heights[i]) minHeightIndex = i;
//       }
//       int curArea = heights[minHeightIndex] * (end -start + 1);
//       int left = calculateArea(heights, start, minHeightIndex - 1);
//       int right = calculateArea(heights, minHeightIndex + 1, end);
//       return Math.max(curArea, Math.max(left, right));
//     }
// }

class Solution {
  public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int res = 0;
    for (int i = 0; i < heights.length; i++) {
      while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
        int preHeight = heights[stack.pop()];
        int width = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
        res = Math.max(res, preHeight * width);
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      int preHeight = heights[stack.pop()];
      int width = heights.length - (stack.isEmpty() ? 0 : stack.peek() + 1);
      res = Math.max(res, preHeight * width);
    }
    return res;
  }
}
