package dp;

/**
 * @author Tosca
 * @date 2020/7/9
 *
 * leetcode 72
 */
public class EditDistance {
  // 基本思路 i,j分别指向word1与word2
  // a) word1[i] == word2[j]时， 跳过该字母(i.e., 不操作)
  // b) word1[i] != word2[j]时， 三种操作 增/删/改

  // 个人认为这道题不好想的是i，j各自做指针指向字符串的字母，相互比较
  // i,j分别从两个字符串最后向前推
  // 题目问什么，就把什么做状态。(优先考虑)

  // 状态定义： dp[i][j] 把word1的前i个，变为word2的前j个，所需要的最小操作 (所以dp数组要多1位)
  // 状态方程：
  // 1. word1[i] = word2[j]
  // dp[i][j] = dp[i-1][j-1]
  // 2. word1[i] != word2[j]
  // a) word1增
  // i不移动，j向前推一位， +1 means 增加一步操作
  // dp[i][j] = dp[i][j-1] + 1
  // b) word1删
  // i向前一位，j不移动
  // dp[i][j] = dp[i-1][j] + 1
  // c) word1替换
  // 替换后i,j同时前移
  // dp[i][j] = dp[i-1][j-1] + 1

  // 初始化状态
  // i == 0 或者 j == 0 返回另一个字符串的剩余长度
  public int minDistance(String word1, String word2) {
    if (word1 == null && word2 == null) return 0;
    if (word1 == null || word1.length() == 0) {
      return word2.length();
    }
    if (word2 == null || word2.length() == 0) {
      return word1.length();
    }

    // 为了不处理数组越界问题，dp状态增加一位
    int dp[][] = new int[word1.length()+1][word2.length()+1];

    for (int i = 0; i <= word1.length(); ++i) {
      dp[i][0] = i;
    }

    for (int j = 0; j <= word2.length(); ++j) {
      dp[0][j] = j;
    }

    for (int i = 1; i <= word1.length(); ++i) {
      for (int j = 1; j <= word2.length(); ++j) {
        // 注意dp状态比字符串多一位 dp[0][0]表示两个字符串都为空
        if (word1.charAt(i-1) == word2.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1];
        } else {
          dp[i][j] = Math.min(dp[i][j-1] + 1,
              Math.min(dp[i-1][j] + 1, dp[i-1][j-1] + 1));
        }
      }
    }

    return dp[word1.length()][word2.length()];
  }

  public static void main(String[] args) {
    String s1 = "sad";
    String s2 = "apple";

    EditDistance ed = new EditDistance();
    int min = ed.minDistance(s1, s2);
    System.out.println(min);
  }
}
