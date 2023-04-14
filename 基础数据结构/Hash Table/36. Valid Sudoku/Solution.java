import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean isValidSudoku(char[][] board) {
    int N = 9;
    Set<Character>[] rows = new HashSet[N];
    Set<Character>[] cols = new HashSet[N];
    Set<Character>[] boxes = new HashSet[N];

    for (int i = 0; i < N; i++) {
      rows[i] = new HashSet<>();
      cols[i] = new HashSet<>();
      boxes[i] = new HashSet<>();
    }

    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        char val = board[r][c];
        if (val == '.')
          continue;

        if (rows[r].contains(val))
          return false;
        rows[r].add(val);

        if (cols[c].contains(val))
          return false;
        cols[c].add(val);

        int idx = (r / 3) * 3 + c / 3;
        if (boxes[idx].contains(val))
          return false;
        boxes[idx].add(val);
      }
    }
    return true;
  }
}