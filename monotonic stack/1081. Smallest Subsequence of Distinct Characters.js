/**
 * @param {string} s
 * @return {string}
 */
var smallestSubsequence = function (s) {
  const stack = [];
  const lastIndex = new Map();
  const visited = new Set();
  for (let i = 0; i < s.length; i++) lastIndex.set(s[i], i);
  for (let i = 0; i < s.length; i++) {
    const c = s[i];
    if (visited.has(c)) continue;
    while (
      stack.length &&
      c < stack[stack.length - 1] &&
      i < lastIndex.get(stack[stack.length - 1])
    ) {
      visited.delete(stack.pop());
    }
    stack.push(c);
    visited.add(c);
  }
  return stack.join("");
};
