/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var multiply = function (num1, num2) {
  if (num1 === "0" || num2 === "0") return "0";
  let m = num1.length;
  let n = num2.length;
  let resArr = Array(m + n).fill(0);
  for (let i = m - 1; i >= 0; i--) {
    for (let j = n - 1; j >= 0; j--) {
      const product = (num1[i] - 0) * (num2[j] - 0);
      const tmp = resArr[i + j + 1] + product;
      resArr[i + j + 1] = tmp % 10;
      resArr[i + j] += Math.floor(tmp / 10);
    }
  }
  return resArr[0] === 0 ? resArr.slice(1).join("") : resArr.join("");
};
