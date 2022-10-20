/**
 * @param {string} s
 * @return {string}
 */
var removeDuplicates = function (s) {
  let res = [];
  let i = 0,
    j = 0;
  while (j < s.length) {
    res[i] = s[j];
    if (i > 0 && res[i] === res[i - 1]) {
      res[i] = res[i - 1] = "";
      i -= 2;
    }
    i++;
    j++;
  }
  return res.join("");
};
