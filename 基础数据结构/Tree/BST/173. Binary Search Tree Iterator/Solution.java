class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  };

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class BSTIterator {
  private Stack<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    pushAllLeft(root);
  }

  public int next() {
    TreeNode node = stack.pop();
    pushAllLeft(node.right);
    return node.val;
  }

  public boolean hasNext() {
    return stack.size() != 0;
  }

  public void pushAllLeft(TreeNode root) {
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }
}