/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function (root, k) {
  let count = 0;
  let stack = [];
  while (root !== null || stack.length !== 0) {
    while (root !== null) {
      stack.push(root);
      root = root.left;
    }
    root = stack.pop();
    count++;
    if (count === k) return root.val;
    root = root.right;
  }
};

// var kthSmallest = function(root, k) {
//     let count = 0;

//     const helper = (root, k) =>{
//         if(root === null) return null;
//         let left = helper(root.left, k);
//         if(left !== null) return left;
//         count++;
//         if(count === k) return root.val;
//         return helper(root.right, k);
//     }

//     return helper(root, k);
// };
