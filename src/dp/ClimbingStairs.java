package dp;

/**
 * @author Tosca
 * @date 2020/7/9
 */
public class ClimbingStairs {
  public int climbStairs(int n) {
    int dp[] = new int[n];
    if (n == 0) return 0;
    if (n == 1) return 1;

    for (int i = 0; i < n; ++i) {
      if (i == 0 || i == 1) {
        dp[0] = 1;
        dp[1] = 2;
        continue;
      }
      dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n-1];
  }
}
