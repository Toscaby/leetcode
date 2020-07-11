package dp;

/**
 * @author Tosca
 * @date 11/7/2020
 *
 * leetcode 5
 */
public class LongestPalindromicSubstring {
  // 1. 状态定义 dp[i][j] 从i开始到j结束的字符串是否为回文
  // 2. 方程 dp[i][j] = dp[i+1][j-1]
  // 3. 初始化状态 i == j 时 dp[i][j] = true
  public String longestPalindrome(String s) {
    int n = s.length();
    if (n == 0) return "";

    boolean dp[][] = new boolean[n][n];
    char arr[] = new char[n];
    for (int i = 0; i < n; ++i) {
      dp[i][i] = true;
      arr[i] = s.charAt(i);
    }

    // 当前最长子回文串的起始结束下标
    int result[] = {0, 0};
    for (int j = 1; j < n; ++j) {
      for (int i = 0; i < j; ++i) {
        if (arr[i] == arr[j]) {
          if (i == j - 1) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i+1][j-1];
          }
        } else {
          dp[i][j] = false;
        }

        if (dp[i][j]) {
          if (j - i > result[1] - result[0]) {
            result[0] = i;
            result[1] = j;
          }
        }
      }
    }
    return s.substring(result[0], result[1] + 1);
  }
}
