package stackandqueue;

import java.util.Stack;

/**
 * @author Tosca
 * @date 2020/6/29
 */
public class BackspaceStringCompare {
  Stack<Character> stack1 = new Stack<>();
  Stack<Character> stack2 = new Stack<>();

  public boolean backspaceCompare(String S, String T) {
    if (S == null || T == null) return false;
    for (int i = 0; i < S.length(); ++i) {
      char c = S.charAt(i);
      pushOrPop(c, stack1);
    }

    for (int i = 0; i < T.length(); ++i) {
      char c = T.charAt(i);
      pushOrPop(c, stack2);
    }

    while (!stack1.isEmpty() && !stack2.isEmpty()) {
      if (stack1.pop() != stack2.pop()) return false;
    }

    if (!stack1.isEmpty() || !stack2.isEmpty()) return false;
    return true;
  }

  private void pushOrPop(char c, Stack<Character> stack2) {
    if (c == '#') {
      if (!stack2.isEmpty()) {
        stack2.pop();
      }
    } else {
      stack2.push(c);
    }
  }

  public static void main(String[] args) {
    BackspaceStringCompare bsc = new BackspaceStringCompare();
    boolean b = bsc.backspaceCompare("ac##ef", "a#c#ee#f");
    System.out.println(b);
  }
}
