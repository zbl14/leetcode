/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function (candidates, target) {
  const res = [];
  backtracking(0, [], 0, candidates, target, res);
  return res;
};

const backtracking = (i, temp, total, candidates, target, res) => {
  if (total === target) return res.push([...temp]);
  if (i >= candidates.length || total > target) return;
  temp.push(candidates[i]);
  backtracking(i, temp, total + candidates[i], candidates, target, res);
  temp.pop();
  backtracking(i + 1, temp, total, candidates, target, res);
};
