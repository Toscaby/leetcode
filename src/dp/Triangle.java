package dp;

import java.util.List;

/**
 * @author Tosca
 * @date 2020/7/9
 *
 * leetcode 120
 */
public class Triangle {
  // 哇 一把过 我真牛逼
  public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) return 0;
    int m = triangle.size();
    int n = triangle.get(m-1).size();
    if (m == 1) {
      List<Integer> list = triangle.get(0);
      list.sort((o1, o2) -> o2 - o1);
      return list.get(0);
    }

    int[][] dp = new int[m][n];
    for (int j = 0; j < triangle.get(m-1).size(); ++j) {
      dp[m-1][j] = triangle.get(m-1).get(j);
    }

    for (int i = m-2; i >= 0; --i) {
      for (int j = triangle.get(i).size()-1; j >= 0; --j) {
        int cur = triangle.get(i).get(j);
        dp[i][j] = Math.min(dp[i+1][j+1], dp[i+1][j]) + cur;
      }
    }
    return dp[0][0];
  }
}
