package ClassicExam.array;

public class LC1143_最长公共子序列_动态规划 {

    /**
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     * <p>
     * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * <p>
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     */
    public int longestCommonSubsequence(String text1, String text2) {

        // 动态规划

        int Max_i = text1.length() + 1;
        int Max_j = text2.length() + 1;

        // 声明 dp[i][j] 数组 表示两个字符串的最长公共子序列为 dp[i][i]

        int[][] dp = new int[Max_i][Max_j];

        // 确定递推公式

        //  i,j 相等： dp[i][j] =dp[i-1][j-1]+1;
        //  i,j 不相等：dp[i][j]= max( dp[i-1][j] , dp[i][j-1]  )

        //初始化 i=1;j=1
        for (int i = 1; i < Max_i; i++) {
            char c = text1.charAt(i - 1);
            for (int j = 1; j < Max_j; j++) {
                char c1 = text2.charAt(j - 1);
                if (c == c1) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

}
