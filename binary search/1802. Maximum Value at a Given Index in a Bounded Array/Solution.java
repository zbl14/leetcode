class Solution {
  public int maxValue(int n, int index, int maxSum) {
    int l = 1;
    int r = maxSum;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (isValid(n, index, maxSum, mid)) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return r;
  }

  private boolean isValid(int n, int index, int maxSum, int value) {
    long sum = 0;
    if (value > index) {
      sum += (long) (value + value - index) * (index + 1) / 2;
    } else {
      sum += (long) (value + 1) * value / 2 + index - value + 1;
    }

    if (value >= n - index) {
      sum += (long) (value + value - n + 1 + index) * (n - index) / 2;
    } else {
      sum += (long) (value + 1) * value / 2 + n - index - value;
    }
    return sum - value <= maxSum;
  }
}