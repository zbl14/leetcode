// class Solution {
//     public boolean canJump(int[] nums) {
//         int[] memo = new int[nums.length];
//         Arrays.fill(memo, - 1);
//         memo[nums.length - 1] = 1;
//         return canJumpFromPos(0, nums, memo) == 1;
//     }

//     private int canJumpFromPos(int pos, int[] nums, int[] memo){
//         if(memo[pos] != -1) return memo[pos];
//         int furthest = Math.min(pos + nums[pos], nums.length - 1);
//         for(int next = pos + 1; next <= furthest; next++){
//             if(canJumpFromPos(next, nums, memo) == 1) return memo[pos] = 1;
//         }
//         return memo[pos] = -1;
//     }
// }

// class Solution {
//     public boolean canJump(int[] nums) {
//         int max = 0;
//         for(int i = 0; i < nums.length; i++){
//             if(i <= max) max = Math.max(i + nums[i], max);
//         }
//         return max >= nums.length - 1;
//     }
// }

public class Solution {
  public boolean canJump(int[] nums) {
    int lastPos = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i + nums[i] >= lastPos) {
        lastPos = i;
      }
    }
    return lastPos == 0;
  }
}