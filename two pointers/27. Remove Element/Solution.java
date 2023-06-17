// class Solution {
//     public int removeElement(int[] nums, int val) {
//         if(nums.length == 0) return 0;
//         if(nums.length == 1) return nums[0] == val ? 0 : 1;
//         int l = 0;
//         int r = nums.length - 1;
//         while(l <= r){
//             while(l <= r && nums[l] != val){
//                 l++;
//             }
//             while(l <= r && nums[r] == val){
//                 r--;
//             }
//             if(l < r) {
//                 int temp = nums[l];
//                 nums[l] = nums[r];
//                 nums[r] = temp;
//             }
//         }
//         return l;
//     }
// }

class Solution {
  public int removeElement(int[] nums, int val) {
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] != val) {
        nums[i] = nums[j];
        i++;
      }
    }
    return i;
  }
}
