import java.util.Arrays;

class Solution {
  public int[][] kClosest(int[][] points, int k) {
    divide(points, 0, points.length - 1, k);
    return Arrays.copyOf(points, k);
  }

  private void divide(int[][] points, int l, int r, int k) {
    if (l >= r)
      return;
    int pos = partition(points, l, r);
    if (pos == k)
      return;
    else if (pos < k) {
      divide(points, pos + 1, r, k);
    } else {
      divide(points, l, pos - 1, k);
    }
  }

  private void swap(int[][] points, int i, int j) {
    int[] temp = points[i];
    points[i] = points[j];
    points[j] = temp;
  }

  private int partition(int[][] points, int l, int r) {
    int pivot = l;
    int pivotDis = getDist(points[pivot]);
    while (l <= r) {
      while (l <= r && getDist(points[l]) <= pivotDis)
        l++;
      while (l <= r && getDist(points[r]) > pivotDis)
        r--;
      if (l > r)
        break;
      swap(points, l, r);
    }
    swap(points, r, pivot);
    return r;
  }

  private int getDist(int[] p) {
    return p[0] * p[0] + p[1] * p[1];
  }
}