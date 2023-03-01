/**
 * @param {string} word
 * @param {string} abbr
 * @return {boolean}
 */
var validWordAbbreviation = function (word, abbr) {
  let i = 0;
  let j = 0;
  while (i < word.length && j < abbr.length) {
    if (/\d/.test(abbr[j])) {
      let numStr = "";
      if (abbr[j] === "0") return false;
      while (j < abbr.length && /\d/.test(abbr[j])) {
        numStr += abbr[j];
        j++;
      }
      let num = parseInt(numStr);
      i += num;
    } else {
      if (word[i] !== abbr[j]) return false;
      i++;
      j++;
    }
  }
  return i === word.length && j === abbr.length;
};
