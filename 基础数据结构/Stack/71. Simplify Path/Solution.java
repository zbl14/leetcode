class Solution {
  public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    String[] pathArr = path.split("/");
    for (String str : pathArr) {
      if (str.equals(".") || str.isEmpty()) {
        continue;
      } else if (str.equals("..")) {
        if (!stack.isEmpty())
          stack.pop();
      } else {
        stack.push(str);
      }
    }
    StringBuilder res = new StringBuilder();
    for (String str : stack) {
      res.append("/");
      res.append(str);
    }
    return res.length() > 0 ? res.toString() : "/";
  }
}