// TC = O(klogn), SC = O(1)
class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    divide(matrix, 0, rows * cols - 1, k);
    return matrix[(k - 1) / cols][(k - 1) % cols];
  }

  private void divide(int[][] matrix, int l, int r, int k) {
    if (l >= r)
      return;
    int rows = matrix.length;
    int cols = matrix[0].length;
    int pos = partition(matrix, l, r);
    int target = k - 1;
    if (pos == target)
      return;
    else if (pos < target)
      divide(matrix, pos + 1, r, k);
    else
      divide(matrix, l, pos - 1, k);
  }

  private int partition(int[][] matrix, int l, int r) {
    int cols = matrix[0].length;
    int pivot = matrix[r / cols][r % cols];
    int wall = l;
    for (int i = l; i < r; i++) {
      if (matrix[i / cols][i % cols] < pivot) {
        swap(matrix, i, wall);
        wall++;
      }
    }
    swap(matrix, wall, r);
    return wall;
  }

  private void swap(int[][] matrix, int i, int j) {
    int cols = matrix[0].length;
    int temp = matrix[i / cols][i % cols];
    matrix[i / cols][i % cols] = matrix[j / cols][j % cols];
    matrix[j / cols][j % cols] = temp;
  }
}
