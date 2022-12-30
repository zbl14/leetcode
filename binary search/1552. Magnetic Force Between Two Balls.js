/**
 * @param {number[]} position
 * @param {number} m
 * @return {number}
 */
var maxDistance = function (position, m) {
  position.sort((a, b) => a - b);
  firstPos = position[0];
  lastPos = position[position.length - 1];
  let max = lastPos - firstPos;
  return m === 2 ? max : binary(max, 1);

  function binary(hight, low) {
    let mid;
    while (low <= hight) {
      mid = low + ((hight - low) >> 1);
      isValid(mid) ? (low = mid + 1) : (hight = mid - 1);
    }
    return hight;
  }

  function isValid(minForce) {
    let prev = 0;
    let count = 1;
    for (let i = 1; i < position.length; i++) {
      if (position[i] - position[prev] >= minForce) {
        count++;
        prev = i;
        if (count === m) return true;
      }
    }
    if (count < m) return false;
    return false;
  }
};
