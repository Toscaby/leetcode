package arrayandlinkedlist;

/**
 * @author Tosca
 * @date 21/6/2020
 */
public class SwapNodeInPairs {
  public ListNode swapPairs(ListNode head) {
    ListNode dump = new ListNode(0);
    dump.next = head;
    head = dump;
    ListNode n1, n2;
    while (head.next != null && head.next.next != null) {
      n1 = head.next;
      n2 = head.next.next;
      head.next = n2;
      n1.next = n2.next;
      n2.next = n1;
      head = n1;
    }
    return dump.next;
  }
}
