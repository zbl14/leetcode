/**
 * @param {string} s
 * @return {string}
 */
var removeDuplicateLetters = function (s) {
  const stack = [];
  const visited = new Set();
  const last = [];
  for (let i = 0; i < s.length; i++) last[s[i]] = i;
  for (let i = 0; i < s.length; i++) {
    const letter = s[i];
    if (visited.has(letter)) continue;
    while (
      stack.length &&
      letter < stack[stack.length - 1] &&
      i < last[stack[stack.length - 1]]
    )
      visited.delete(stack.pop());
    stack.push(letter);
    visited.add(letter);
  }
  return stack.join("");
};
