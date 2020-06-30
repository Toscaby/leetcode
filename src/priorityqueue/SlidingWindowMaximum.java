package priorityqueue;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author Tosca
 * @date 2020/6/30
 */
public class SlidingWindowMaximum {
  /* Max Heap */
  public int[] maxSlidingWindow0(int[] nums, int k) {
    int[] ret = new int[nums.length - k + 1];
    /* 创建大顶堆 */
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
    for (int i = 0; i < k - 1; ++i) {
      maxHeap.add(nums[i]);
    }
    for (int i = 0; i < ret.length; ++i) {
      maxHeap.add(nums[i + k - 1]);
      ret[i] = maxHeap.peek();
      maxHeap.remove(nums[i]);
    }
    return ret;
  } // 大顶堆会超时

  /* deque，队列中储存的是元素的下标 */
  public int[] maxSlidingWindow(int[] nums, int k) {
    // 返回数组的大小 nums.length - k + 1
    int[] ret = new int[nums.length - k + 1];
    Deque<Integer> deque = new ArrayDeque<>(k);
    for (int i = 0; i < nums.length; ++i) {
      // 队列存储的是窗口内元素的下标
      // 队首元素小于窗口左端下标，出队
      if (i >= k && i - k + 1 > deque.peek()) {
        deque.remove();
      }

      // 小于即将入队的元素从右边出队
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.removeLast();
      }

      deque.offer(i);

      // 这样可以保证左边一直是最大的 (实际上是保证队列是倒序的)
      if (i >= k - 1) {
        ret[i - k + 1] = nums[deque.peek()];
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    SlidingWindowMaximum swm = new SlidingWindowMaximum();
    //int[] nums = {1,3,-1,-3,5,3,6,7};
    int[] nums = {1,3,1,2,0,5};
    int[] ret = swm.maxSlidingWindow(nums, 3);
    for (int i : ret) {
      PrintUtil.println(i);
    }
  }
}
