class Solution {
  public int[][] findMaximalUncoveredRanges(int n, int[][] ranges) {
    if (ranges.length == 0) {
      return new int[][] { { 0, n - 1 } };
    }

    Arrays.sort(ranges, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
    List<int[]> list = new ArrayList<>();
    int cur = 0;
    for (int[] range : ranges) {
      int x = range[0];
      int y = range[1];
      if (cur < x) {
        list.add(new int[] { cur, x - 1 });
      }
      cur = Math.max(cur, y + 1);
    }
    if (cur < n)
      list.add(new int[] { cur, n - 1 });

    // int[][] ans = new int[list.size()][2];
    // for(int i = 0; i < list.size(); i++){
    // ans[i][0] = list.get(i)[0];
    // ans[i][1] = list.get(i)[1];
    // }
    // return ans;
    return list.toArray(new int[list.size()][2]);
  }
}