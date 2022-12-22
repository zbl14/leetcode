/**
 * @param {number} n
 * @return {number}
 */
var totalNQueens = function (n) {
  const cols = new Set();
  const mainDiag = new Set();
  const antiDiag = new Set();
  const result = [];
  backtrack(0, n, cols, mainDiag, antiDiag, result, []);
  return result.length;
};

function backtrack(row, n, cols, mainDiag, antiDiag, result, temp) {
  if (row === n) result.push([...temp]);
  for (let i = 0; i < n; i++) {
    if (!cols.has(i) && !mainDiag.has(row + i) && !antiDiag.has(row - i)) {
      cols.add(i);
      mainDiag.add(row + i);
      antiDiag.add(row - i);
      temp[row] = i;
      backtrack(row + 1, n, cols, mainDiag, antiDiag, result, temp);
      cols.delete(i);
      mainDiag.delete(row + i);
      antiDiag.delete(row - i);
    }
  }
}
