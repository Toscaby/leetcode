package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tosca
 * @date 1/7/2020
 */
public class TwoSum {
  Map<Integer, Integer> map = new HashMap();
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; ++i) {
      map.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; ++i) {
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[] {i, map.get(complement)};
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }
}
