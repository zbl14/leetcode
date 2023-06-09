// brute force, TC = O(nm), SC = O(1)
// class Solution {
//     public int countNegatives(int[][] grid) {
//         if(grid == null || grid.length == 0) return -1;
//         int cnt = 0;
//         for(int i = 0; i < grid.length; i++){
//             for(int j = grid[0].length - 1; j >= 0; j--){
//                 if(grid[i][j] < 0) {
//                     cnt++;
//                 } else {
//                     break;
//                 }
//             }
//         }
//         return cnt;
//     }
// }

// binary search, TC = O(mlogn)
// class Solution {
//     public int countNegatives(int[][] grid) {
//         if(grid == null || grid.length == 0) return -1;
//         int cnt = 0;
//         for(int[] row : grid){
//             int l = 0;
//             int r = grid[0].length - 1;
//             while(l <= r){
//                 int mid = l + (r - l) / 2;
//                 if(row[mid] < 0){
//                     r = mid - 1;
//                 } else {
//                     l = mid + 1;
//                 }
//             }
//             cnt += grid[0].length - l;
//         }
//         return cnt;
//     }
// }

// linear search, TC = O(m + n)
class Solution {
  public int countNegatives(int[][] grid) {
    if (grid == null || grid.length == 0)
      return -1;
    int cnt = 0;
    int curRowNegativeIdx = grid[0].length - 1;
    for (int[] row : grid) {
      while (curRowNegativeIdx >= 0 && row[curRowNegativeIdx] < 0) {
        curRowNegativeIdx--;
      }
      cnt += grid[0].length - (curRowNegativeIdx + 1);
    }
    return cnt;
  }
}
