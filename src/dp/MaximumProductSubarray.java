package dp;

import java.util.Arrays;

/**
 * @author Tosca
 * @date 9/7/2020
 *
 * leetcode 152
 */
public class MaximumProductSubarray {
  // 基本的状态方程
  // dp[i] -> 从i起始的最大连续子数组的乘积
  // dp[i] = dp[i+1] * nums[i] > nums[i] ? dp[i+1] * nums[i] : nums[i]
  // 有问题 [-3,-1,-1] 连续负数可能翻正

  // dp[i][0] -> 从i起始的最大连续子数组的乘积
  // dp[i][1] -> 从i起始的最小值

  // dp[i][0] = max(dp[i+1][0] * nums[i], dp[i+1][1] * nums[i], nums[i]) // 当前起点为正时，跟下一组
  // dp[i][1] = min(dp[i+1][1] * nums[i], dp[i+1][0] * nums[i], nums[i])
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];

    // 这里为了排序方便，把dp数组行列反一下
    int[][] dp = new int[2][nums.length];

    dp[0][nums.length-1] = dp[1][nums.length-1] = nums[nums.length-1];
    for (int i = nums.length - 2; i >= 0; --i) {
      dp[0][i] = Math.max(dp[0][i+1] * nums[i], Math.max(dp[1][i+1] * nums[i], nums[i]));
      dp[1][i] = Math.min(dp[1][i+1] * nums[i], Math.min(dp[0][i+1] * nums[i], nums[i]));
    }

    int[] arr = dp[0];
    Arrays.sort(arr);
    return arr[nums.length-1];
  }

  public static void main(String[] args) {
    MaximumProductSubarray mps = new MaximumProductSubarray();
    int[] test = {-3, -1, -1};
    System.out.println(mps.maxProduct(test));
  }
}
