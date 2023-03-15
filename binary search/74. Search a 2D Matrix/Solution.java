class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int l = 0;
    int r = rows * cols - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (matrix[mid / cols][mid % cols] == target)
        return true;
      else if (matrix[mid / cols][mid % cols] < target)
        l = mid + 1;
      else
        r = mid - 1;
    }
    return false;
  }
}