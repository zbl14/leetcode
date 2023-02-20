/**
 * @param {string} s
 * @return {boolean}
 */
/**
 * @param {string} s
 * @return {boolean}
 */
var validPalindrome = function (s) {
  let left = 0;
  right = s.length - 1;
  while (left < right) {
    if (s[left] == s[right]) {
      left++;
      right--;
    } else {
      return IsPalindrom(left + 1, right, s) || IsPalindrom(left, right - 1, s);
    }
  }
  return true;
};

let IsPalindrom = (left, right, s) => {
  while (left < right) {
    if (s[left] == s[right]) {
      left++;
      right--;
    } else return false;
  }
  return true;
};
