package arrayandlinkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tosca
 * @date 21/6/2020
 */
public class LinkedListCycle {
  private Set<ListNode> set = new HashSet<>();
  public boolean hasCycle(ListNode head) {
    while (head != null) {
      if (set.contains(head)) {
        return true;
      }
      set.add(head);
      head = head.next;
    }
    return false;
  }

  public boolean hasCycle2(ListNode head) {
    ListNode slow = head, fast = head;
    while (slow != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}
