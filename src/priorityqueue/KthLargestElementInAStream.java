package priorityqueue;

import java.util.PriorityQueue;

/**
 * @author Tosca
 * @date 2020/6/30
 */
public class KthLargestElementInAStream {
  private PriorityQueue<Integer> priorityQueue;
  private int k;

  public KthLargestElementInAStream(int k, int[] nums) {
    this.k = k;
    // 维护一个容量为k的堆 Java优先队列默认是小顶堆
    priorityQueue = new PriorityQueue<>(k);
    for (int i : nums) {
      add(i);
    }
  }

  public int add(int val) {
    if (priorityQueue.size() < k) {
      priorityQueue.offer(val);
    } else if (priorityQueue.peek() < val) {
      priorityQueue.poll();
      priorityQueue.offer(val);
    }
    return priorityQueue.peek();
  }

  public static void main(String[] args) {
    int[] nums = {3, 10, 2, 5};
    KthLargestElementInAStream k = new KthLargestElementInAStream(3, nums);
    PrintUtil.println(k.add(7));
    PrintUtil.println(k.add(9));
    PrintUtil.println(k.add(6));
    PrintUtil.println(k.add(1));
    PrintUtil.println(k.add(8));
  }

}
