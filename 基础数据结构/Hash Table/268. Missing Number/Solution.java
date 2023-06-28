// TC = O(nlogn), SC = O(1)
// class Solution {
//     public int missingNumber(int[] nums) {
//         Arrays.sort(nums);
//         for(int i = 0; i < nums.length; i++){
//             if(i != nums[i]) return i;
//         }
//         return nums.length;
//     }
// }

// TC = O(n), SC = O(n)
// class Solution {
//     public int missingNumber(int[] nums) {
//         Set<Integer> set = new HashSet<>();
//         for(int num : nums){
//             set.add(num);
//         }
//         for(int i = 0; i < nums.length; i++){
//             if(!set.contains(i)) return i;
//         }
//         return nums.length;
//     }
// }

// TC = O(n), SC = O(1)
class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int arr[] = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };

    int res = solution.missingNumber(arr);

    System.out.println(res);
  }

  public int missingNumber(int[] nums) {
    int expectedSum = nums.length * (nums.length + 1) / 2;
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    return expectedSum - sum;
  }
}