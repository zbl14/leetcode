/**
 * @param {number[]} fruits
 * @return {number}
 */
var totalFruit = function (fruits) {
  const map = new Map();
  let res = 0;
  let l = 0;
  for (let r = 0; r < fruits.length; r++) {
    map.set(fruits[r], map.get(fruits[r]) + 1 || 1);
    while (map.size > 2) {
      map.set(fruits[l], map.get(fruits[l]) - 1);
      if (map.get(fruits[l]) === 0) map.delete(fruits[l]);
      l++;
    }
    res = Math.max(res, r - l + 1);
  }
  return res;
};
