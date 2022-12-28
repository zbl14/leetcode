/**
 * @param {number[]} jobs
 * @param {number} k
 * @return {number}
 */
var minimumTimeRequired = function (jobs, k) {
  jobs.sort((a, b) => a - b); // pruning
  if (jobs.length === k) return jobs.pop();
  let result = Infinity;
  const workerArr = Array(k).fill(0);
  backtrack(jobs.length - 1, workerArr); // 从大的开始assign
  return result;

  function backtrack(lastJobIndex, workerArr) {
    if (lastJobIndex < 0) {
      result = Math.min(result, Math.max(...workerArr));
      return;
    }
    if (Math.max(...workerArr) >= result) return; // pruning
    for (let i = 0; i < k; i++) {
      if (i > 0 && workerArr[i] === workerArr[i - 1]) continue; //pruning
      workerArr[i] += jobs[lastJobIndex];
      backtrack(lastJobIndex - 1, workerArr);
      workerArr[i] -= jobs[lastJobIndex];
    }
  }
};
