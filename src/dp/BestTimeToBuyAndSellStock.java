package dp;

/**
 * @author Tosca
 * @date 2020/7/8
 *
 * leetcode 121
 */

//  股票通用模板
//  1. 三种行为 buy/sell/rest
//  2. 状态：今天操作行为后的最大利润 三个影响维度(三个) ：天数i 最多交易次数j 是否持仓k
//  3. 穷举状态：
//  for i in days:
//    for j in remainingTransaction:
//      for k in (0 or 1):
//        dp[i][j][k] = max(buy, sell, rest) // 第几天，手上是否持有股票，还能交易几次
//  4. 行为导致的状态转移：
//  sell -> rest(空仓)
//  rest -> rest
//  buy -> rest(持仓)
//  5. 根据状态转移关系列方程：
//  dp[i][j][0] = max(sell, rest) //导致当前这个状态的是 1. 今天刚卖出 2. 昨天就空仓了，今天没操作
//  dp[i][j][0] = amx(dp[i-1][j][1] + price[i], dp[i-1][j][0])
//  dp[i][j][1] = max(buy, rest) //导致当前这个状态的是 1. 今天刚买入 2. 昨天就持仓了，今天没操作
//  dp[i][j][1] = max(dp[i-1][j-1][0] - price[i], dp[i-1][j][1])
//  6. 基础状态
//  dp[-1][j][0] = 0 // 第0天，未开始，盈利0
//  dp[-1][j][1] = not_exist // 不存在这种状态
//  dp[i][0][0] = 0 // 不许交易，没有盈利
//  dp[i][0][1] = not_exist // 不存在这种状态

// 一买一卖记作一次操作 所以只有买入时减少j

// 201 只能操作一次，所以j的最大值为1。
public class BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    // dp 方程
    //int dp[][][] = new int[prices.length][2][2];
    //
    //for (int i = 0; i < prices.length; ++i) {
    //  for (int j = 0; j <= 1; ++j) {
    //    dp[i][j][0] = Math.max(dp[i-1][j][1] + prices[i], dp[i-1][j][0]);
    //    dp[i][j][1] = Math.max(dp[i-1][j-1][0] - prices[i], dp[i-1][j][1]);
    //  }
    //}

    // 简化
    // 注意所有j == 0时，表示0次操作，dp[i][0][k] == 0, 所以可以减少一个维度
    //dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
    //dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
    //    = max(dp[i-1][1][1], -prices[i])
    if (prices.length == 0) return 0;

    int dp[][] = new int[prices.length][2];
    for (int i = 0; i < prices.length; ++i) {
      if (i == 0) {
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        continue;
      }

      dp[i][0] = Math.max(dp[i-1][1] + prices[i], dp[i-1][0]);
      dp[i][1] = Math.max(-prices[i], dp[i-1][1]);
    }

    return dp[prices.length-1][0];
  }
}
