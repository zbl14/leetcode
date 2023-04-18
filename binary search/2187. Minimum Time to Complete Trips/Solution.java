class Solution {
  public long minimumTime(int[] time, int totalTrips) {
    int maxTime = Integer.MIN_VALUE;
    for (int t : time) {
      maxTime = Math.max(maxTime, t);
    }
    long l = 1;
    long r = (long) maxTime * totalTrips;
    while (l <= r) {
      long mid = l + (r - l) / 2;
      if (isValid(mid, time, totalTrips))
        r = mid - 1;
      else
        l = mid + 1;
    }
    return l;
  }

  private boolean isValid(long t, int[] time, int totalTrips) {
    long sum = 0;
    for (int i = 0; i < time.length; i++) {
      sum += t / time[i];
      if (sum >= totalTrips)
        return true;
    }
    return false;
  }
}