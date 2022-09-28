/**
 * @param {number} n
 * @return {string[][]}
 */

var solveNQueens = function (n) {
  const cols = new Set();
  const mainDiag = new Set();
  const antiDiag = new Set();
  const result = [];
  backtrack(0, n, cols, mainDiag, antiDiag, result, []);
  return draw(result, n);
};

var backtrack = function (row, n, cols, mainDiag, antiDiag, result, temp) {
  if (row === n) {
    result.push([...temp]);
  }
  for (let i = 0; i < n; i++) {
    if (!cols.has(i) && !antiDiag.has(row - i) && !mainDiag.has(row + i)) {
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
};

function draw(array, n) {
  const result = [];
  array.forEach((element) => {
    const panel = [];
    element.forEach((index) => {
      const temp = new Array(n).fill(".");
      temp[index] = "Q";
      panel.push(temp.join(""));
    });
    result.push(panel);
  });
  return result;
}
