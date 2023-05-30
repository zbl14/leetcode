class Solution {
  public int maxSubArrayLen(int[] nums, int k) {
    int currSum = 0, maxLen = 0;
    HashMap<Integer, Integer> sumToIndexMap = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      currSum += nums[i];
      if (currSum == k) {
        maxLen = i + 1;
      }
      if (sumToIndexMap.containsKey(currSum - k)) {
        maxLen = Math.max(maxLen, i - sumToIndexMap.get(currSum - k));
      }
      if (!sumToIndexMap.containsKey(currSum))
        sumToIndexMap.put(currSum, i);
    }
    return maxLen;
  }
}