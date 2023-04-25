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
  private int idx = -1;

  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    build(root);
  }

  public void build(TreeNode root) {
    if (root == null)
      return;
    build(root.left);
    stack.push(root);
    build(root.right);
  }

  public boolean hasNext() {
    return idx < stack.size() - 1;
  }

  public int next() {
    if (idx < stack.size() - 1) {
      idx++;
      int next = stack.get(idx).val;
      return next;
    }
    return -1;
  }

  public boolean hasPrev() {
    return idx > 0;
  }

  public int prev() {
    if (idx > 0 && idx < stack.size()) {
      idx--;
      int prev = stack.get(idx).val;
      return prev;
    }
    return -1;
  }
}