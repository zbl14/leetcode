// TC = O(mn*(m+n)), SC = O(mn)
// class Solution {
//     public void setZeroes(int[][] matrix) {
//         boolean[][] visited = new boolean [matrix.length][matrix[0].length];
//         for(int i = 0; i < matrix.length; i++){
//             for(int j = 0; j < matrix[0].length; j++){
//                 if(matrix[i][j] == 0 && !visited[i][j]) helper(matrix, i, j, visited);
//             }
//         }
//     }

//     private void helper(int[][] matrix, int x, int y, boolean[][] visited){
//         visited[x][y] = true;
//         for(int i = 0; i < matrix.length; i++){
//             if(matrix[i][y] == 0) continue;
//             if(!visited[i][y]) {
//                 matrix[i][y] = 0;
//                 visited[i][y] = true;
//             }
//         }
//         for(int j = 0; j < matrix[0].length; j++){
//             if(matrix[x][j] == 0) continue;
//             if(!visited[x][j]) {
//                 matrix[x][j] = 0;
//                 visited[x][j] = true;
//             }
//         }
//     }
// }

// TC = O(mn), SC = O(mn)
class Solution {
  public void setZeroes(int[][] matrix) {
    Set<Integer> rows = new HashSet<>();
    Set<Integer> cols = new HashSet<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          cols.add(j);
        }
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (rows.contains(i) || cols.contains(j)) {
          matrix[i][j] = 0;
        }
      }
    }
  }
}