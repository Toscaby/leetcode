package stackandqueue;

import java.util.Stack;

/**
 * @author Tosca
 * @date 2020/6/29
 */
public class ImplementQueueUsingStacks {
}

class MyQueue {
  Stack<Integer> stackIn;
  Stack<Integer> stackOut;

  /** Initialize your data structure here. */
  public MyQueue() {
    stackIn = new Stack<>();
    stackOut = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    stackIn.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    if (stackOut.isEmpty()) {
      while (!stackIn.isEmpty()) {
        stackOut.push(stackIn.pop());
      }
    }
    return stackOut.pop();
  }

  /** Get the front element. */
  public int peek() {
    if (stackOut.isEmpty()) {
      while (!stackIn.isEmpty()) {
        stackOut.push(stackIn.pop());
      }
    }
    return stackOut.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return stackIn.empty() && stackOut.empty();
  }
}
