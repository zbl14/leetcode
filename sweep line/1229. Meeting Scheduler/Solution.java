import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
    Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
    int i = 0;
    int j = 0;
    while (i < slots1.length && j < slots2.length) {
      int commonTimeStart = Math.max(slots1[i][0], slots2[j][0]);
      int commonTimeEnd = Math.min(slots1[i][1], slots2[j][1]);
      if (commonTimeEnd - commonTimeStart >= duration) {
        return new ArrayList<Integer>(Arrays.asList(commonTimeStart, commonTimeStart + duration));
      } else if (slots1[i][1] < slots2[j][1]) {
        i++;
      } else {
        j++;
      }
    }
    return new ArrayList<Integer>();
  }
}

// sweep line
// class Solution {
// public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int
// duration) {

// if(slots1.length == 0 || slots2.length == 0) return new ArrayList<>();
// List<int[]> list = new ArrayList();
// int j = 0;
// for(int i = 0; i < slots1.length; i++){
// list.add(new int[]{slots1[i][0],1});
// list.add(new int[]{slots1[i][1],-1});
// }

// for(int i = 0; i < slots2.length; i++){
// list.add(new int[]{slots2[i][0],1});
// list.add(new int[]{slots2[i][1],-1});
// }

// Collections.sort(list, (a,b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
// int numOfPeople = 0;
// int prev = -1;
// for(int[] event : list){
// if(numOfPeople == 2 && (event[0] - prev) >= duration){
// return Arrays.asList(prev, prev + duration);
// }
// numOfPeople += event[1];
// prev = event[0];
// }

// return new ArrayList<>();
// }
// }