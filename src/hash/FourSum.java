package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tosca
 * @date 1/7/2020
 */
public class FourSum {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> retList = new ArrayList<>();

    Arrays.sort(nums);
    for (int i = 0; i < nums.length; ++i) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      for (int j = i + 1; j < nums.length; ++j) {
        if (j > i + 1 && nums[j] == nums[j - 1]) continue;

        int head = j + 1;
        int tail = nums.length - 1;

        while (head < tail) {
          if (tail < nums.length - 1 && nums[tail] == nums[tail + 1]) {
            tail --;
            continue;
          }

          List<Integer> set = new ArrayList<>();
          if (nums[i] + nums[j] + nums[head] + nums[tail] == target) {
            set.add(nums[i]);
            set.add(nums[j]);
            set.add(nums[head]);
            set.add(nums[tail]);
            retList.add(set);
            head ++;
            tail --;
          } else if (nums[i] + nums[j] + nums[head] + nums[tail] > target) {
            tail --;
          } else {
            head ++;
          }
        }
      }
    }
    return retList;
  }
}
