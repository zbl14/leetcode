/**
 * @param {string} s
 * @return {string}
 */
var frequencySort = function (s) {
  let charFreq = {};
  let result = "";
  for (const char of s) {
    charFreq[char] ? charFreq[char]++ : (charFreq[char] = 1);
  }
  const sorted = Object.keys(charFreq).sort(
    (a, b) => charFreq[b] - charFreq[a]
  );
  for (let i = 0; i < sorted.length; i++) {
    result += sorted[i].repeat(charFreq[sorted[i]]);
  }
  return result;
};
