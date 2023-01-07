/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function (s, t) {
  let r = 0,
    l = 0,
    mapT = {},
    map = {},
    countT = 0;
  if (s.length < t.length) return "";
  for (let i = 0; i < t.length; i++) {
    const char = t.charAt(i);
    if (!mapT[char]) {
      mapT[char] = 1;
      countT++; // types of letter in mapT
    } else {
      mapT[char]++;
    }
  }
  let charType = 0;
  let minWindow = [0, s.length - 1, Infinity];
  while (r < s.length) {
    const char = s.charAt(r);
    if (!map[char]) {
      map[char] = 1;
    } else {
      map[char]++;
    }
    if (mapT[char] && mapT[char] == map[char]) {
      charType++;
    }
    while (charType == countT && l <= r) {
      if (r - l + 1 < minWindow[2]) {
        minWindow = [l, r, r - l + 1];
        // initial value of minWindow[2] is Infinity
        // if minWindow[2] > s.length, means window never slid, should return ""
      }
      map[s.charAt(l)]--;
      if (mapT[s.charAt(l)] && map[s.charAt(l)] < mapT[s.charAt(l)]) {
        charType--;
      }
      l++;
    }
    r++;
  }
  return minWindow[2] > s.length
    ? ""
    : s.substring(minWindow[0], minWindow[1] + 1);
};
