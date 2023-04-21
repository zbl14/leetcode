import java.util.Random;

// TC = O(nlogk), SC = O(k)
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//         for(int num : nums){
//             minHeap.add(num);
//             if(minHeap.size() > k) minHeap.poll();
//         }
//         return minHeap.poll();
//     }
// }

// TC = O(n), SC = O(1)
class Solution {
  public int findKthLargest(int[] nums, int k) {
    shuffle(nums);
    divide(nums, 0, nums.length - 1, k);
    return nums[nums.length - k];
  }

  private void divide(int[] nums, int l, int r, int k) {
    if (l >= r)
      return;
    int pos = quickSelect(nums, l, r);
    int target = nums.length - k;
    if (pos == target)
      return;
    else if (pos < target)
      divide(nums, pos + 1, r, k);
    else
      divide(nums, l, pos - 1, k);
  }

  private int quickSelect(int[] nums, int l, int r) {
    int pivot = nums[r];
    int wall = l;
    for (int i = l; i < r; i++) {
      if (nums[i] < pivot) {
        swap(nums, i, wall);
        wall++;
      }
    }
    swap(nums, wall, r);
    return wall;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void shuffle(int[] nums) {
    Random random = new Random();
    for (int i = 0; i < nums.length; i++) {
      int j = random.nextInt(i + 1);
      swap(nums, i, j);
    }
  }
}