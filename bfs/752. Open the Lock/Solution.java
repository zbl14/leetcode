import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
  public int openLock(String[] deadends, String target) {
    if (target.equals("0000"))
      return 0;
    Set<String> visited = new HashSet<>(Arrays.asList(deadends));
    if (visited.contains("0000"))
      return -1;

    Queue<String> q = new LinkedList<>();
    q.offer("0000");
    visited.add("0000");

    int cnt = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        String curr = q.poll();
        for (int j = 0; j < 4; j++) {
          char c = curr.charAt(j);
          String up = curr.substring(0, j) + (c == '9' ? 0 : c - '0' + 1) + curr.substring(j + 1);
          String dwn = curr.substring(0, j) + (c == '0' ? 9 : c - '0' - 1) + curr.substring(j + 1);

          if (up.equals(target) || dwn.equals(target))
            return cnt + 1;

          if (!visited.contains(up)) {
            q.offer(up);
            visited.add(up);
          }
          if (!visited.contains(dwn)) {
            q.offer(dwn);
            visited.add(dwn);
          }
        }

      }
      cnt++;
    }
    return -1;
  }
}