/**
 * Encodes a list of strings to a single string.
 *
 * @param {string[]} strs
 * @return {string}
 */
var encode = function (strs) {
  let res = "";
  for (let i = 0; i < strs.length; i++) {
    res += strs[i].length + "#" + strs[i];
  }
  return res;
};

/**
 * Decodes a single string to a list of strings.
 *
 * @param {string} s
 * @return {string[]}
 */
var decode = function (s) {
  const res = [];
  let l = 0;
  let r = 0;
  while (r < s.length) {
    l = r;
    while (s[r] !== "#") r++;
    const wordLen = Number(s.slice(l, r));
    const start = r + 1;
    const end = start + wordLen;
    const word = s.slice(start, end);
    res.push(word);
    r = end;
  }
  return res;
};

/**
 * Your functions will be called as such:
 * decode(encode(strs));
 */
