package dp;

/**
 * @author Tosca
 * @date 2020/7/8
 */
public class BestTimeToBuyAndSellStockII {
  // j <= prices.length - 1

  public int maxProfit(int[] prices) {
    if (prices.length == 0) return 0;
    int dp[][] = new int[prices.length][2];
    //  dp[i][j][0] = max(sell, rest) //导致当前这个状态的是 1. 今天刚卖出 2. 昨天就空仓了，今天没操作
    //  dp[i][j][0] = max(dp[i-1][j][1] + price[i], dp[i-1][j][0])
    //  dp[i][j][1] = max(buy, rest) //导致当前这个状态的是 1. 今天刚买入 2. 昨天就持仓了，今天没操作
    //  dp[i][j][1] = max(dp[i-1][j-1][0] - price[i], dp[i-1][j][1])

    // 推出公式就要相信公式
    // j = 正无穷 ==> j = j - 1
    //dp[i][j][0] = Math.max(dp[i-1][j][1] + prices[i], dp[i-1][j][0]);
    //dp[i][j][1] = Math.max(dp[i-1][j][0] - prices[i], dp[i-1][j][1]);
    // 发现j在公式中没有变化
    for (int i = 0; i < prices.length; ++i) {
      if (i == 0) {
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        continue;
      }

      dp[i][0] = Math.max(dp[i-1][1] + prices[i], dp[i-1][0]);
      dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
    }
    return dp[prices.length-1][0];
  }
}
