package stackandqueue;

import java.util.Stack;

/**
 * @author Tosca
 * @date 2020/6/29
 */
public class ValidParentheses {
  Stack<Character> stack = new Stack<>();
  public boolean isValid(String s) {
    for (int i = 0; i < s.length(); i ++) {
      char c = s.charAt(i);
      if (c == '{' || c == '(' || c == '[') {
        stack.push(c);
      } else {
        if (stack.empty()) {
          return false;
        }

        char top = stack.pop();
        if ((c == '}' && top == '{') || (c == ']' && top == '[') || (c == ')' && top == '(')) {

        } else {
          return false;
        }
      }
    }
    return stack.empty();
  }
}
