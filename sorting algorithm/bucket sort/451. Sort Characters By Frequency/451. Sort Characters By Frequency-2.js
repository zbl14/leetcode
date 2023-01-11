/**
 * @param {string} s
 * @return {string}
 */
var frequencySort = function (s) {
  let res = "";
  const map = new Map();
  for (let i = 0; i < s.length; i++) map.set(s[i], (map.get(s[i]) || 0) + 1);
  const mapAscByValue = new Map([...map.entries()].sort((a, b) => b[1] - a[1]));
  mapAscByValue.forEach((element, key) => {
    while (element-- > 0) res += key;
  });
  return res;
};
