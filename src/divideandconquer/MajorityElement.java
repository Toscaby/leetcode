package divideandconquer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tosca
 * @date 2020/7/7
 */
public class MajorityElement {

  // #1 使用map O(N)
  public int majorityElement0(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    int majority = nums[0];
    int majority_time = map.get(nums[0]);
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int time = entry.getValue();
      if (time > nums.length / 2 && time > majority_time) {
        majority = entry.getKey();
        majority_time = time;
      }
    }
    return majority;
  }

  // #2 排序 O(NlgN)
  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }

  // #3 分治 O(NlgN)
  // 分成左右两边
  //public int majorityElement(int[] nums) {
  //
  //}
}
