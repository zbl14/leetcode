/**
 * @param {string} num
 * @param {number} k
 * @return {string}
 */
var removeKdigits = function (num, k) {
  if (num.length === k) return "0";
  const stack = [];
  for (let i = 0; i < num.length; i++) {
    while (stack.length && num[i] < stack[stack.length - 1] && k > 0) {
      stack.pop();
      k--;
    }
    stack.push(+num[i]);
  }
  while (k--) stack.pop();
  while (stack[0] === 0 && stack.length > 1) stack.shift();
  return stack.join("");
};

// var removeKdigits = function (num, k) {
//   const numArr = num.split("").map(Number);
//   const stack = [];
//   for (let i = 0; i < numArr.length; i++) {
//     while (stack.length && numArr[i] < stack[stack.length - 1] && k > 0) {
//       stack.pop();
//       k--;
//     }
//     stack.push(numArr[i]);
//   }
//   while (k--) stack.pop();
//   while (stack[0] === 0) stack.shift();
//   return stack.length ? stack.join("") : "0";
// };
