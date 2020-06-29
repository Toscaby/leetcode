package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Tosca
 * @date 2020/6/29
 */
public class ImplementStackUsingQueues {
}

class MyStack {
  Queue<Integer> queue;
  Queue<Integer> queueTmp;

  /** Initialize your data structure here. */
  public MyStack() {
    queue = new LinkedList<>();
    queueTmp = new LinkedList<>();
  }

  /** Push element x onto stack. */
  public void push(int x) {
    while (!queue.isEmpty()) {
      queueTmp.add(queue.poll());
    }
    queue.add(x);
    while (!queueTmp.isEmpty()) {
      queue.add(queueTmp.poll());
    }
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    return queue.poll();
  }

  /** Get the top element. */
  public int top() {
    return queue.peek();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return queue.isEmpty();
  }
}