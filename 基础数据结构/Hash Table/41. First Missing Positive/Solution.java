// TC = O(n), SC = O(n)
// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         Set<Integer> set = new HashSet<>();
//         int max = 0;
//         for(int num : nums){
//             set.add(num);
//             max = Math.max(max, num);
//         }
//         if(max == 0) return 1;
//         for(int i = 1; i < max; i++){
//             if(!set.contains(i)) return i;
//         }
//         return max + 1;
//     }
// }

// TC = O(n), SC = O(1)
class Solution {
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;

    boolean hasOne = false;
    for (int num : nums) {
      if (num == 1) {
        hasOne = true;
        break;
      }
    }
    if (!hasOne)
      return 1;

    // remove negative num and num that larger than n
    for (int i = 0; i < n; i++) {
      if (nums[i] <= 0 || nums[i] > n) {
        nums[i] = 1;
      }
    }

    // use idx 0 to store whether has n in the array
    // if num[1] is negative, means '1' is in the array
    for (int i = 0; i < n; i++) {
      int cur = Math.abs(nums[i]);
      if (cur == n) {
        nums[0] = -Math.abs(nums[0]);
      } else {
        nums[cur] = -Math.abs(nums[cur]);
      }
    }

    for (int i = 1; i < n; i++) {
      if (nums[i] > 0) {
        return i;
      }
    }

    if (nums[0] > 0)
      return n;

    return n + 1;
  }
}
