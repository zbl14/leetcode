// class Solution {
//     public boolean canReach(int[] arr, int start) {
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(start);

//         while(!q.isEmpty()){
//           int cur = q.poll();
//           if(arr[cur] == 0) return true;
//           if(arr[cur] < 0) continue;

//           if(cur + arr[cur] < arr.length){
//             q.offer(cur + arr[cur]);
//           }
//           if(cur - arr[cur] >= 0){
//             q.offer(cur - arr[cur]);
//           }
//           arr[cur] = - arr[cur];
//         }
//         return false;
//     }
// }

class Solution {
  public boolean canReach(int[] arr, int start) {
    if (start >= 0 && start < arr.length && arr[start] >= 0) {
      if (arr[start] == 0) {
        return true;
      }
      arr[start] = -arr[start];
      return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
    }
    return false;
  }
}