/**
 * @param {number[]} bloomDay
 * @param {number} m
 * @param {number} k
 * @return {number}
 */
var minDays = function (bloomDay, m, k) {
  if (bloomDay.length < m * k) return -1;
  let max = Math.max(...bloomDay);
  return binary(1, max);

  function binary(low, hight) {
    let mid;
    while (low <= hight) {
      mid = low + ((hight - low) >> 1);
      isValid(mid) ? (hight = mid - 1) : (low = mid + 1);
    }
    return low;
  }

  function isValid(minDays) {
    let bouquetCount = 0;
    let flowerCount = 0;
    for (let i = 0; i < bloomDay.length; i++) {
      if (bloomDay[i] <= minDays) {
        flowerCount++;
        if (flowerCount === k) {
          bouquetCount++;
          flowerCount = 0;
        }
      } else {
        flowerCount = 0;
      }
    }
    return bouquetCount >= m;
  }
};
