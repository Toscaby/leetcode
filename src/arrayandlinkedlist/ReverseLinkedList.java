package arrayandlinkedlist;

/**
 * @author Tosca
 * @date 21/6/2020
 */
public class ReverseLinkedList {
  public static void main(String[] args) {

  }

  public ListNode reverseList(ListNode head) {
    ListNode newHead = null;
    ListNode next = null;

    if (head != null) { // node 1
      newHead = head;
      head = head.next;
      next = head;
      newHead.next = null;
    }

    while (next != null) {
      next = next.next;
      head.next = newHead;
      newHead = head;
      head = next;
    }
    return newHead;
  }

  public ListNode reverseList2(ListNode head) {
    if (head != null) {
      return head;
    }
    ListNode prev = head, cur = head.next;
    ListNode temp;
    while (cur != null) {
      temp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = temp;
    }
    head.next = null;
    return prev;
  }
}