// 372. Super Pow;

class Solution {
  final int k = 1337;

  public int superPow(int a, int[] b) {
    int ans = 1;

    for (int i = b.length - 1; i >= 0; i--) {
      ans = (ans * pow(a, b[i])) % k;
      a = pow(a, 10);
    }

    return ans;
  }

  private int pow(int a, int b) {
    if (b == 0)
      return 1;

    if (b % 2 == 1) {
      return (a % k * pow(a, b - 1)) % k;
    } else {
      int sub = pow(a, b / 2);
      return (sub * sub) % k;
    }
  }
}