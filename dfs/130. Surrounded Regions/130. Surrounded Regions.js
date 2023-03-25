/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
 var solve = function(board) {
  const rows = board.length,
        cols = board[0].length,
        matrix = Array(rows).fill().map(() => Array(cols).fill(false));
  for(let r = 0; r < rows; r++) {
      dfs(board, matrix, r, 0, rows, cols);
      dfs(board, matrix, r, cols-1, rows, cols);
  }
  
  for(let c = 0; c < cols; c++) {
      dfs(board, matrix, 0, c, rows, cols);
      dfs(board, matrix, rows-1, c, rows, cols);
  }

  for(let r = 0; r < rows; r++) {
      for(let c = 0; c < cols; c++){
          if(matrix[r][c] === false && board[r][c] === "O") {
              board[r][c] = "X";
          }
      }
  }
};

const dfs = (board, matrix, r, c, rows, cols) => {
  const direction = [-1, 0, 1, 0, -1];
  if(r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] || board[r][c] === "X") {
      return;
  }
  if(board[r][c] === "O") {
      matrix[r][c] = true;
   }
  for(let k = 0; k < 4; k++) {
      const newR = r + direction[k];
      const newC = c + direction[k+1];
      dfs(board, matrix, newR, newC, rows, cols);
  } 
};