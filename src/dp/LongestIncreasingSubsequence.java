package dp;

import java.util.Arrays;

/**
 * @author Tosca
 * @date 10/7/2020
 *
 * leetcode 300
 */
public class LongestIncreasingSubsequence {
  // 1. 定义状态 dp[i] --> 以nums[i]为结尾的 最长上升子序列的长度
  // 2. 状态方程
  // dp[i] = {max dp[j] (j >= 0 && j < i)} + 1
  // 解释： 遍历nums[i]之前的元素，只要有nums[j] < nums[i]，dp[i] = dp[j] + 1
  // 找出dp[j]的最大值即可

  // 3. 初始状态值
  // dp[i] = 1
  public int lengthOfLIS(int[] nums) {
    if (nums == null) return 0;

    int len = nums.length;
    if (len < 2) return len;

    int[] dp = new int[len];
    Arrays.fill(dp, 1);

    for (int i = 1; i < len; ++i) {
      for (int j = 0; j < i; ++j) {
        if (nums[i] > nums[j]) {
          // 这里其实不大懂
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    int res = 0;
    for (int i = 0; i < len; ++i) {
      if (dp[i] > res) {
        res = dp[i];
      }
    }
    return res;
  }
}
