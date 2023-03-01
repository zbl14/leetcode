/**
 * @param {string} s
 * @return {number}
 */
var calculate = function (s) {
  let curNum = 0;
  let oper = "+";
  const stack = [];
  for (let i = 0; i < s.length; i++) {
    const cur = s[i];
    if (cur >= "0" && cur <= "9") {
      curNum = curNum * 10 + Number(cur);
    }
    if ("+-*/".includes(cur) || i == s.length - 1) {
      if (oper === "+") stack.push(curNum);
      if (oper === "-") stack.push(-curNum);
      if (oper === "*") stack.push(stack.pop() * curNum);
      if (oper === "/") {
        const tmp = stack.pop() / curNum;
        tmp > 0 ? stack.push(Math.floor(tmp)) : stack.push(Math.ceil(tmp));
      }
      oper = cur;
      curNum = 0;
    }
  }
  return stack.reduce((a, b) => a + b);
};
