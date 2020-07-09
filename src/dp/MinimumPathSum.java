package dp;

/**
 * @author Tosca
 * @date 2020/7/9
 *
 * leetcode 64
 */

// 状态方程
// dp[i][j] = Math.min(dp[i-1][j] + grid[i][j], dp[i][j-1] + grid[i][j])
public class MinimumPathSum {
  public int minPathSum(int[][] grid) {
    if (grid == null) return 0;

    int m = grid.length; // 行数
    int n = grid[0].length; // 列数
    if (m == 1 && n == 1) return grid[0][0];

    int dp[][] = new int[m][n];
    dp[0][0] = grid[0][0];
    for (int i = 1; i < m; ++i) {
      dp[i][0] = dp[i-1][0] + grid[i][0];
    }

    for (int j = 1; j < n; ++j) {
      dp[0][j] = dp[0][j-1] + grid[0][j];
    }

    for (int i = 1; i < m; ++i) {
      for (int j = 1; j < n; ++j) {
        dp[i][j] = Math.min(dp[i-1][j] + grid[i][j], dp[i][j-1] + grid[i][j]);
      }
    }

    return dp[m-1][n-1];
  }

  public static void main(String[] args) {
    int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};

    MinimumPathSum mps = new MinimumPathSum();
    int min = mps.minPathSum(grid);
    System.out.println(grid.length);
    System.out.println(grid[0].length);
    System.out.println(min);
  }
}
