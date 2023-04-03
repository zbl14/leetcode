class Solution {
  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int lo = 0;
    int hi = people.length - 1;
    int res = 0;

    while (lo <= hi) {
      res++;
      if (people[lo] + people[hi] <= limit) {
        lo++;
        hi--;
      } else {
        hi--;
      }
    }
    return res;
  }
}