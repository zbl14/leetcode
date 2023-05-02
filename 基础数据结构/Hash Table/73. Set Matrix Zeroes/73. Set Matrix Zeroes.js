/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function (matrix) {
  const rowSet = new Set();
  const colSet = new Set();
  for (let i = 0; i < matrix.length; i++) {
    for (let j = 0; j < matrix[0].length; j++) {
      if (matrix[i][j] === 0) {
        rowSet.add(i);
        colSet.add(j);
      }
    }
  }
  for (const i of rowSet) {
    for (let col = 0; col < matrix[0].length; col++) matrix[i][col] = 0;
  }
  for (const j of colSet) {
    for (let row = 0; row < matrix.length; row++) matrix[row][j] = 0;
  }
};
