class Solution {
  private int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

  public void solve(char[][] board) {
    int rows = board.length;
    int cols = board[0].length;
    boolean[][] visited = new boolean[rows][cols];
    for (int r = 0; r < rows; r++) {
      dfs(board, visited, r, 0, rows, cols);
      dfs(board, visited, r, cols - 1, rows, cols);
    }
    for (int c = 0; c < cols; c++) {
      dfs(board, visited, 0, c, rows, cols);
      dfs(board, visited, rows - 1, c, rows, cols);
    }

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (visited[r][c] == false && board[r][c] == 'O') {
          board[r][c] = 'X';
        }
      }
    }
  }

  private void dfs(char[][] board, boolean[][] visited, int r, int c, int rows, int cols) {
    if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || board[r][c] == 'X')
      return;
    if (board[r][c] == 'O')
      visited[r][c] = true;
    for (int[] dir : dirs) {
      dfs(board, visited, r + dir[0], c + dir[1], rows, cols);
    }
  }
}