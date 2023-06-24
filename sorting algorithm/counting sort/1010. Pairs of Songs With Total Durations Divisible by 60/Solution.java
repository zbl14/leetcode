// brute force, TC = O(n^2), SC = O(1), TLE
// class Solution {
//     public int numPairsDivisibleBy60(int[] time) {
//       if(time.length <= 1) return 0;
//       int res = 0;
//       for(int i = 0; i < time.length; i++){
//         for(int j = i+1; j < time.length; j++){
//           if((time[i] + time[j]) % 60 == 0) res++;
//         }
//       }
//       return res;
//     }
// }

// TC = O(n), SC = O(1), similar to two sum
class Solution {
  public int numPairsDivisibleBy60(int[] time) {
    int remainders[] = new int[60];
    int cnt = 0;
    for (int t : time) {
      if (t % 60 == 0) {
        cnt += remainders[0];
      } else {
        cnt += remainders[60 - t % 60];
      }
      remainders[t % 60]++;
    }
    return cnt;
  }
}