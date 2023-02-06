/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function (s, p) {
  const res = [];
  const map = new Map();
  for (let i = 0; i < p.length; i++) {
    map.set(p[i], map.get(p[i]) + 1 || 1);
  }
  let l = 0;
  let count = p.length;
  for (let r = 0; r < s.length; r++) {
    if (map.has(s[r])) {
      map.set(s[r], map.get(s[r]) - 1);
      if (map.get(s[r]) >= 0) {
        count--;
        if (count === 0) res.push(l);
      }
    }
    if (r >= p.length - 1) {
      if (map.has(s[l])) {
        map.set(s[l], map.get(s[l]) + 1);
        if (map.get(s[l]) > 0) {
          count++;
        }
      }
      l++;
    }
  }
  return res;
};
