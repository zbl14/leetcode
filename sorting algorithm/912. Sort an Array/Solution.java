// quick sort, nlogn
// class Solution {
//     public int[] sortArray(int[] nums) {
//         shuffle(nums);
//         quickSort(nums, 0, nums.length - 1);
//         return nums;
//     }

//     private void quickSort(int[] nums, int l, int r) {
//         if (l < r) {
//             int partitionIndex = partition(nums, l, r);
//             quickSort(nums, l, partitionIndex - 1);
//             quickSort(nums, partitionIndex + 1, r);
//         }
//     }

//     private int partition(int[] nums, int l, int r){
//         int pivot = l;
//         while(l <= r){
//             while(l <= r && nums[l] <= nums[pivot]){
//                 l++;
//             }
//             while(l <= r && nums[r] > nums[pivot]){
//                 r--;
//             }
//             if(l > r){
//                 break;
//             }
//             swap(nums, l, r);
//         }
//         swap(nums, r, pivot);
//         return r;
//     }

//     private void swap(int[] nums, int l, int r){
//         int temp = nums[l];
//         nums[l] = nums[r];
//         nums[r] = temp;
//     }

//     private void shuffle(int[] nums) {
//         Random random = new Random();
//         for (int i = 0; i < nums.length; i++) {
//             int j = random.nextInt(i + 1);
//             swap(nums, i, j);
//         }
//     }
// }

// counting sort, TC = O(n + k), SC = O(n + k)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = { 3, 1, 2, 2, 2, 4, 6, 8, 0, 9 }; // Example input
    int[] sortedNums = solution.sortArray(nums);

    System.out.println(Arrays.toString(sortedNums));
  }

  public int[] sortArray(int[] nums) {
    Map<Integer, Integer> cnt = new HashMap<>();
    int min = nums[0];
    int max = nums[0];

    for (int num : nums) {
      min = Math.min(min, num);
      max = Math.max(max, num);
      cnt.put(num, cnt.getOrDefault(num, 0) + 1);
    }

    int idx = 0;
    for (int val = min; val <= max; val++) {
      while (cnt.getOrDefault(val, 0) > 0) {
        nums[idx] = val;
        idx++;
        cnt.put(val, cnt.get(val) - 1);
      }
    }
    return nums;
  }
}