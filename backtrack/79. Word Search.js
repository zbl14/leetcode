/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function (board, word) {
  const visited = Array(board.length)
    .fill()
    .map(() => Array(board[0].length).fill(false));
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[0].length; j++) {
      if (
        board[i][j] === word[0] &&
        backtracking(i, j, visited, board, word, 0)
      ) {
        return true;
      }
    }
  }
  return false;
};

const backtracking = (row, col, visited, board, word, index) => {
  if (index === word.length) return true;
  if (
    row < 0 ||
    row >= board.length ||
    col < 0 ||
    col >= board[0].length ||
    visited[row][col] ||
    board[row][col] !== word[index]
  )
    return false;
  visited[row][col] = true;
  const res =
    backtracking(row + 1, col, visited, board, word, index + 1) ||
    backtracking(row - 1, col, visited, board, word, index + 1) ||
    backtracking(row, col + 1, visited, board, word, index + 1) ||
    backtracking(row, col - 1, visited, board, word, index + 1);
  visited[row][col] = false;
  return res;
};
