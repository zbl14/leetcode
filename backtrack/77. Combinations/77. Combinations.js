/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function (n, k) {
  let res = [];
  backtrace([]);
  return res;

  function backtrace(curList) {
    if (curList.length === k) {
      res.push([...curList]);
    } else {
      for (let i = 1; i <= n; i++) {
        let qualified = false;
        for (let j = 0; j < k; j++) {
          if (curList[j] >= i) {
            qualified = true;
            break;
          }
        }
        if (qualified) {
          continue;
        }
        curList.push(i);
        backtrace(curList);
        curList.pop();
      }
    }
  }
};
