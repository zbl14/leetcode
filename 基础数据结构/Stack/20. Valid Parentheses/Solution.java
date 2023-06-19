// class Solution {
//     public boolean isValid(String s) {
//       if(s.length() % 2 != 0 || s.length() == 0) return false;
//       Map<Character, Character> map = Map.of(')', '(' , ']', '[', '}', '{') ;

//       Stack<Character> stack = new Stack<>();
//         for (char c : s.toCharArray()) {
//             if (map.containsKey(c)) {
//                 if (stack.isEmpty() || stack.pop() != map.get(c)) {
//                     return false;
//                 }
//             } else {
//                 stack.push(c);
//             }
//         }
//         return stack.isEmpty();
//     }
// }

class Solution {
  public boolean isValid(String s) {
    if (s.length() % 2 != 0 || s.length() == 0)
      return false;
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        stack.push(s.charAt(i));
      } else {
        if (stack.isEmpty())
          return false;
        else {
          char top = stack.peek();
          if ((top == '(' && c == ')') || (top == '[' && c == ']') || (top == '{' && c == '}')) {
            stack.pop();
          } else {
            return false;
          }
        }
      }
    }
    return stack.isEmpty();
  }
}
