class Solution {
  int[][] memo;

  public int maxUncrossedLines(int[] nums1, int[] nums2) {
    memo = new int[nums1.length + 1][nums2.length + 1];
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }

    return dfs(nums1, nums2, 0, 0);
  }

  private int dfs(int[] nums1, int[] nums2, int i, int j) {
    if (i >= nums1.length || j >= nums2.length)
      return 0;
    if (memo[i][j] != -1)
      return memo[i][j];
    int res = 0;
    if (nums1[i] == nums2[j]) {
      res = 1 + dfs(nums1, nums2, i + 1, j + 1);
    } else {
      res = Math.max(dfs(nums1, nums2, i, j + 1), dfs(nums1, nums2, i + 1, j));
    }
    memo[i][j] = res;
    return memo[i][j];
  }
}