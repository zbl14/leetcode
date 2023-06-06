class Solution {
  public boolean checkStraightLine(int[][] coordinates) {
    if (coordinates.length < 2)
      return false;
    else if (coordinates.length == 2)
      return true;
    else {
      for (int i = 2; i < coordinates.length; i++) {
        int yDiff1 = coordinates[i - 1][1] - coordinates[i - 2][1];
        int xDiff1 = coordinates[i - 1][0] - coordinates[i - 2][0];
        int yDiff2 = coordinates[i][1] - coordinates[i - 1][1];
        int xDiff2 = coordinates[i][0] - coordinates[i - 1][0];

        if (yDiff1 * xDiff2 != yDiff2 * xDiff1) {
          return false;
        }
      }
    }
    return true;
  }
}