class Solution {
  public int trap(int[] height) {
    if (height.length < 3)
      return 0;

    int left = 0;
    int right = height.length - 1;
    while (left < right && height[left] <= height[left + 1])
      left++;
    while (left < right && height[right] <= height[right - 1])
      right--;

    int leftMax = 0;
    int rightMax = 0;
    int res = 0;
    while (left < right) {
      leftMax = Math.max(leftMax, height[left]);
      rightMax = Math.max(rightMax, height[right]);
      if (height[left] < height[right]) {
        res += leftMax - height[left];
        left++;
      } else {
        res += rightMax - height[right];
        right--;
      }
    }
    return res;
  }
}