// TC = O(mn), SC = O(mn)
class Solution {
  private int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

  public void gameOfLife(int[][] board) {
    boolean[][] nextState = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        nextState[i][j] = isLive(board, i, j);
      }
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        board[i][j] = nextState[i][j] ? 1 : 0;
      }
    }
  }

  private boolean isLive(int[][] board, int i, int j) {
    int liveCount = 0;
    for (int[] d : dirs) {
      int x = i + d[0];
      int y = j + d[1];
      if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 1) {
        liveCount++;
      }
    }
    if (board[i][j] == 0) {
      if (liveCount == 3)
        return true;
    } else {
      if (liveCount < 2)
        return false;
      else if (liveCount == 2 || liveCount == 3)
        return true;
      else
        return false;
    }
    return false;
  }
}