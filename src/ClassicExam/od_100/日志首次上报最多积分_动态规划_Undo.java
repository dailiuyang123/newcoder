package ClassicExam.od_100;

import java.util.Arrays;
import java.util.Scanner;

public class 日志首次上报最多积分_动态规划_Undo {

    /**
     * 日志采集是运维系统的的核心组件。日志是按行生成，每行记做一条，由采集系统分批上报。
     * <p>
     * 如果上报太频繁，会对服务端造成压力;
     * 如果上报太晚，会降低用户的体验；
     * 如果一次上报的条数太多，会导致超时失败。
     * 为此，项目组设计了如下的上报策略：
     * <p>
     * 每成功上报一条日志，奖励1分
     * 每条日志每延迟上报1秒，扣1分
     * 积累日志达到100条，必须立即上报
     * 给出日志序列，根据该规则，计算首次上报能获得的最多积分数。
     * <p>
     * 输入
     * 1 98 1
     * <p>
     * 输出	98
     * 说明	T1 时刻上报得 1 分
     * T2 时刻上报得98分，最大
     * T3 时刻上报得 0 分
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split("\\ ");
        int[] nums = new int[split.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(split[i]);
        }

        System.out.println(getRs(nums));

    }

    public static int getRs(int[] nums) {

        int n = nums.length;

        // dp[i] 表示某一时刻可得的正向得分
        int[] dp = new int[n];
        dp[0] = nums[0];

        // delay[i] 表示某一时刻被扣的负向分
        int[] delay = new int[n];
        delay[0] = 0;

        // score[i] 表示某一时刻的最终得分
        int[] score = new int[n];
        score[0] = dp[0];

        for (int i = 1; i < n; i++) {

            // 正向得分
            dp[i] = Math.min(100, dp[i - 1] + nums[i]);
            // 负向得分
            delay[i] = delay[i - 1] + dp[i - 1];
            score[i] = dp[i] - delay[i];

            // 达到100条时必须上报，此时完成首次上报，结束循环
            if (dp[i] >= 100) {
                break;
            }
        }

        return Arrays.stream(score).max().getAsInt();

    }


}
