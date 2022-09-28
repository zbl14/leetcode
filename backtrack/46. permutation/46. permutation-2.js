/**
 * @param {number[]} nums
 * @return {number[][]}
 */
 var permute = function(nums) {
    let res = [];
    backtracking([]);
    return res;
    
    function backtracking(curList) {
        if(curList.length === nums.length) {
            res.push([...curList]);
            return;
        }
        for(let i = 0; i < nums.length; i++) {
            if(!curList.includes(nums[i])) {
                curList.push(nums[i]);
                backtracking(curList);
                curList.pop();
            }
        }
    }
};