var HitCounter = function () {
  this.q = [];
};

/**
 * @param {number} timestamp
 * @return {void}
 */
HitCounter.prototype.hit = function (timestamp) {
  this.q.push(timestamp);
};

/**
 * @param {number} timestamp
 * @return {number}
 */
// TC = O(n)
// HitCounter.prototype.getHits = function (timestamp) {
//   while (this.q !== 0) {
//     const diff = timestamp - this.q[0];
//     if (diff >= 300) this.q.shift();
//     else break;
//   }
//   return this.q.length;
// };

// TC = O(logn)
HitCounter.prototype.getHits = function (timestamp) {
  let l = 0;
  let r = this.q.length - 1;
  while (l <= r) {
    let mid = l + ((r - l) >> 1);
    this.q[mid] <= timestamp - 300 ? (l = mid + 1) : (r = mid - 1);
  }
  return this.q.length - (r + 1);
};

/**
 * Your HitCounter object will be instantiated and called as such:
 * var obj = new HitCounter()
 * obj.hit(timestamp)
 * var param_2 = obj.getHits(timestamp)
 */
