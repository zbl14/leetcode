import java.util.Arrays;

class Solution {
  public int removeCoveredIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    int res = intervals.length;
    int end = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      if (end >= intervals[i][1]) {
        res--;
      } else {
        end = intervals[i][1];
      }
    }
    return res;
  }
}
