class Solution {
  public int jump(int[] nums) {
    int curFurthest = 0;
    int curEnd = 0;
    int jump = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      curFurthest = Math.max(i + nums[i], curFurthest);
      if (i == curEnd) {
        jump++;
        curEnd = curFurthest;
      }
    }
    return jump;
  }
}