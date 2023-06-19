class Solution {
  public int largestAltitude(int[] gain) {
    int res = 0;
    int altitude = 0;
    for (int num : gain) {
      altitude += num;
      res = Math.max(res, altitude);
    }
    return res;
  }
}