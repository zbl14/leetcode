class Solution {
  public int maxArea(int[] height) {
    int i = 0;
    int j = height.length - 1;
    int res = 0;
    while (i < j) {
      int waterHeight = height[i] < height[j] ? height[i] : height[j];
      res = Math.max(res, waterHeight * (j - i));
      if (height[i] > height[j])
        j--;
      else
        i++;
    }
    return res;
  }
}