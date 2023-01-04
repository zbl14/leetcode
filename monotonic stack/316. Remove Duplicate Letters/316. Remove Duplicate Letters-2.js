/**
 * @param {string} s
 * @return {string}
 */
var removeDuplicateLetters = function (s) {
  const stack = [];
  const visited = new Set();
  const last = new Map();
  for (let i = 0; i < s.length; i++) last.set(s[i], i);
  console.log(last);
  for (let i = 0; i < s.length; i++) {
    const letter = s[i];
    if (visited.has(letter)) continue;
    while (
      stack.length &&
      letter < stack[stack.length - 1] &&
      i < last.get(stack[stack.length - 1])
    ) {
      visited.delete(stack.pop());
    }
    stack.push(letter);
    visited.add(letter);
  }
  return stack.join("");
};
