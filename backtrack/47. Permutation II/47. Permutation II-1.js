/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function (nums) {
  const len = nums.length;
  const ans = [];
  const set = new Set();
  const uniqueSet = new Set();

  const recursePermuteUnique = (set) => {
    if (set.size === len) {
      let temp = [];
      //Create permuation using indexes saved in set
      let str = "";
      set.forEach((d) => {
        temp.push(nums[d]);
        str = str + nums[d];
      });
      if (!uniqueSet.has(str)) {
        ans.push(temp);
        uniqueSet.add(str);
      }
      return null;
    }

    //Track each permutation with indexes saved in the set. Hence, keeping track of unique values.
    for (let i = 0; i < len; i++) {
      if (!set.has(i)) {
        set.add(i);
        recursePermuteUnique(set);
        set.delete(i);
      }
    }
  };

  recursePermuteUnique(set);
  return ans;
};
