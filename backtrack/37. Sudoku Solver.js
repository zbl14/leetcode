/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solveSudoku = function (board) {
  backtrack();

  function backtrack() {
    for (let i = 0; i < board.length; i++) {
      for (let j = 0; j < board[0].length; j++) {
        if (board[i][j] === ".") {
          for (let c = 1; c <= 9; c++) {
            const candidate = c.toString();
            if (isValid(i, j, candidate)) {
              board[i][j] = candidate;
              if (backtrack()) {
                return true;
              }
              board[i][j] = ".";
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  function isValid(r, c, candidate) {
    for (let i = 0; i < 9; i++) {
      if (board[i][c] == candidate || board[r][i] == candidate) {
        return false;
      }

      const boxIndexRow = Math.floor(r / 3) * 3 + Math.floor(i / 3);
      const boxIndexCol = Math.floor(c / 3) * 3 + Math.floor(i % 3);
      if (board[boxIndexRow][boxIndexCol] == candidate) {
        return false;
      }
    }
    return true;
  }
};
