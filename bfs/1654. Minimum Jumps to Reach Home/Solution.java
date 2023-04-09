class Solution {
  public int minimumJumps(int[] forbidden, int a, int b, int x) {
    HashSet<Integer> visited = new HashSet<>();
    for (int val : forbidden) {
      visited.add(val);
    }
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] { 0, 0, 0 });
    visited.add(0);
    while (queue.size() > 0) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] first = queue.remove();
        int currPos = first[0];
        int backwardCnt = first[1];
        int steps = first[2];
        if (currPos == x)
          return steps;
        int backward = currPos - b;
        int forward = currPos + a;
        if (!visited.contains(backward) && backwardCnt == 0 && backward > 0) {
          queue.add(new int[] { backward, 1, steps + 1 });
          visited.add(backward);
        }
        if (!visited.contains(forward) && forward < 6000) {
          queue.add(new int[] { forward, 0, steps + 1 });
          visited.add(forward);
        }
      }
    }
    return -1;

  }
}