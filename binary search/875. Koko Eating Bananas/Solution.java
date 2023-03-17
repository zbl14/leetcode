// 875. Koko Eating Bananas;

class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int maxK = 1;
    for (int i = 0; i < piles.length; i++)
      maxK = Math.max(maxK, piles[i]);
    int lo = 1;
    int hi = maxK;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (isValid(mid, piles, h)) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return lo;
  }

  private boolean isValid(int speed, int[] piles, int h) {
    int hours = 0;
    for (int i : piles) {
      int time = i / speed;
      hours += time;
      if (i % speed != 0)
        hours++;
      if (hours > h)
        return false;
    }
    return true;
  }
}