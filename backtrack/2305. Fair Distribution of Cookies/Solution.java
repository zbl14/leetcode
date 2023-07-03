// class Solution {
//     public int distributeCookies(int[] cookies, int k) {
//         int[] distribuite = new int[k];
//         return backtracking(0, distribuite, cookies, k, k);
//     }

//     private int backtracking(int idx, int[] distribute, int[] cookies, int k, int zeroCnt){
//         if(cookies.length - idx < zeroCnt){
//             return Integer.MAX_VALUE;
//         }

//         if(idx == cookies.length){
//             int unfairness = Integer.MIN_VALUE;
//             for(int d : distribute){
//                 unfairness = Math.max(unfairness, d);
//             }
//             return unfairness;
//         }

//         int res = Integer.MAX_VALUE;
//         for(int i = 0; i < k; i++){
//             zeroCnt -= distribute[i] == 0 ? 1 : 0;
//             distribute[i] += cookies[idx];
//             res = Math.min(res, backtracking(idx + 1, distribute, cookies, k, zeroCnt));
//             distribute[i] -= cookies[idx];
//             zeroCnt += distribute[i] == 0 ? 1 : 0;
//         }
//         return res;
//     }
// }

class Solution {
  int ans;
  int distribuite[];

  public int distributeCookies(int[] cookies, int k) {
    ans = Integer.MAX_VALUE;
    distribuite = new int[k];

    backtrack(0, cookies, k);
    return ans;
  }

  public void backtrack(int idx, int[] cookies, int k) {
    if (idx == cookies.length) {
      int max = 0;
      for (int i = 0; i < k; i++) {
        max = Math.max(max, distribuite[i]);
      }
      ans = Math.min(ans, max);
      return;
    }

    for (int i = 0; i < k; i++) {
      distribuite[i] += cookies[idx];
      backtrack(idx + 1, cookies, k);
      distribuite[i] -= cookies[idx];
      if (distribuite[i] == 0)
        break;
    }
  }
}