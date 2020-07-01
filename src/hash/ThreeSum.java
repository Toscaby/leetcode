package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tosca
 * @date 1/7/2020
 */
public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> retList = new ArrayList<>();
    // 本题的关键在于，避免重复，首先排序
    Arrays.sort(nums);
    // 遍历
    for (int i = 0; i < nums.length; ++i) {
      // 对于每一个不同的nums[i]，每一轮已穷举出所有的可能
      // 所以连续nums[i]相同，skip
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      // b + c = -a
      int target = -nums[i];

      // 头尾指针
      int j = i + 1;
      int k = nums.length - 1;

      // 穷举 b + c = -a组合，直到两个指针相遇
      while (j < k) {
        // 移动头指针,有重复元素skip
        // 这里一点要先找过一次才去重 避免[0, 0, 0]或者[2, -1, -1]这样的组合被skip
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          j ++;
          continue;
        }

        List<Integer> tmp = new ArrayList<>();
        // 找到目标组
        if (nums[j] + nums[k] == target) {
          tmp.add(nums[i]);
          tmp.add(nums[j]);
          tmp.add(nums[k]);
          retList.add(tmp);
          j ++;
          k --;
        } else if (nums[j] + nums[k] > target) {
          // 大于目标，移动尾指针
          k --;
        } else {
          // 小于目标，移动头指针
          j ++;
        }
      }
    }
    return retList;
  }
}
