// recursive
const traversal = (root) => {
  let res = [];
  helper(root, res);
  return res;
};

// preorder
const helper = (root, res) => {
  if (root === null) return;
  res.push(root.val);
  helper(root.left, res);
  helper(root.right, res);
};

// inorder
// const helper = (root, res) => {
//   if (root === null) return;
//   helper(root.left, res);
//   res.push(root.val);
//   helper(root.right, res);
// };

// postorder
// const helper = (root, res) => {
//   if (root === null) return;
//   helper(root.left, res);
//   helper(root.right, res);
//   res.push(root.val);
// };

// iterative
var preorderTraversal = function (root) {
  let stack = [];
  let res = [];
  if (root !== null) stack.push(root);
  while (stack.length) {
    root = stack.pop();
    res.push(root.val);
    if (root.right) stack.push(root.right);
    if (root.left) stack.push(root.left);
  }
  return res;
};

const inorderTraversal = (root) => {
  let res = [];
  let stack = [];
  while (root !== null || stack.length !== 0) {
    while (root !== null) {
      stack.push(root);
      root = root.left;
    }
    root = stack.pop();
    res.push(root.val);
    root = root.right;
  }
  return res;
};

const postorderTraversal = (root) => {
  let res = [];
  let stack = [];
  if (root !== null) stack.push(root);
  while (stack.length !== 0) {
    root = stack.pop();
    res.unshift(root.val);
    if (root.left) stack.push(root.left);
    if (root.right) stack.push(root.right);
  }
  return res;
};

// const preorderTraversal = (root) => {
//   let res = [];
//   let stack = [];
//   let cur = root;
//   while (cur !== null || stack.length !== 0) {
//     if (cur !== null) {
//       res.push(cur.val);
//       stack.push(cur);
//       cur = cur.left;
//     } else {
//       cur = stack.pop();
//       cur = cur.right;
//     }
//   }
//   return res;
// };

// const inorderTraversal = (root) => {
//   let res = [];
//   let stack = [];
//   let cur = root;
//   while (cur !== null || stack.length !== 0) {
//     if (cur !== null) {
//       stack.push(cur);
//       cur = cur.left;
//     } else {
//       cur = stack.pop();
//       res.push(cur.val);
//       cur = cur.right;
//     }
//   }
//   return res;
// };

// const postorderTraversal = (root) => {
//   let resStack = [];
//   let stack = [];
//   let cur = root;
//   while (cur !== null || stack.length !== 0) {
//     if (cur !== null) {
//       resStack.push(cur);
//       stack.push(cur);
//       cur = cur.right;
//     } else {
//       cur = stack.pop();
//       cur = cur.left;
//     }
//   }
//   let res = [];
//   while (resStack.length) res.push(resStack.pop().val);
//   return res;
// };
