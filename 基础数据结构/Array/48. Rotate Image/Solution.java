// class Solution {
//     public void rotate(int[][] matrix) {
//         int n = matrix.length;
//         for(int i = 0; i < (n + 1) / 2; i++){
//             for(int j = 0; j < n / 2; j++){
//                 int temp = matrix[n - 1 - j][i];
//                 matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
//                 matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
//                 matrix[j][n - 1 - i] = matrix[i][j];
//                 matrix[i][j] = temp;
//             }
//         }
//     }
// }

class Solution {
  public void rotate(int[][] matrix) {
    transpose(matrix);
    reflect(matrix);
  }

  public void transpose(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int tmp = matrix[j][i];
        matrix[j][i] = matrix[i][j];
        matrix[i][j] = tmp;
      }
    }
  }

  public void reflect(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[i][n - j - 1];
        matrix[i][n - j - 1] = tmp;
      }
    }
  }
}