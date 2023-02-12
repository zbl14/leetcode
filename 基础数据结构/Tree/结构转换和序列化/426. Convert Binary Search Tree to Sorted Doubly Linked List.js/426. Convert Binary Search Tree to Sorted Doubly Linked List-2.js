var treeToDoublyList = function (root) {
  let pre = null;
  let head = null;
  if (root === null) return root;
  [pre, head] = inorderTraversal(root, pre, head);
  head.left = pre;
  pre.right = head;
  return head;
};

const inorderTraversal = function (node, pre, head) {
  if (node == null) return [pre, head];
  [pre, head] = inorderTraversal(node.left, pre, head);
  if (head === null) head = node;
  if (pre !== null) pre.right = node;
  node.left = pre;
  pre = node;
  [pre, head] = inorderTraversal(node.right, pre, head);
  return [pre, head];
};

// var treeToDoublyList = function (root) {
//   pre = null;
//   head = null;
//   if (root === null) return root;

//   const inorderTraversal = function (node) {
//     if (node == null) return;
//     inorderTraversal(node.left);
//     if (head === null) head = node;
//     if (pre !== null) pre.right = node;
//     node.left = pre;
//     pre = node;
//     inorderTraversal(node.right);
//   };

//   inorderTraversal(root);
//   head.left = pre;
//   pre.right = head;
//   return head;
// };
