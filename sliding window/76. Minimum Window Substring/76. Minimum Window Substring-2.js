/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function (s, t) {
  //该处map的定义并不是windonw里面的char有什么，而是remaing char need to have
  const tMap = new Map();
  for (let i = 0; i < t.length; i++)
    tMap.has(t.charAt(i))
      ? tMap.set(t.charAt(i), tMap.get(t.charAt(i)) + 1)
      : tMap.set(t.charAt(i), 1);
  let l = 0;
  let minStart = 0;
  let count = 0;
  let minLen = Infinity;
  for (let r = 0; r < s.length; r++) {
    const cur = s.charAt(r);
    if (tMap.has(cur)) {
      if (tMap.get(cur) > 0) count++;
      tMap.set(cur, tMap.get(cur) - 1);
    }
    while (count === t.length) {
      if (r - l + 1 < minLen) {
        minLen = r - l + 1;
        minStart = l;
      }
      const lChar = s.charAt(l);
      if (tMap.has(lChar)) {
        tMap.set(lChar, tMap.get(lChar) + 1);
        if (tMap.get(lChar) > 0) count--;
      }
      l++;
    }
  }
  return minLen === Infinity ? "" : s.substring(minStart, minStart + minLen);
};
