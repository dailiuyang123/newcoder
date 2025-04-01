package od_2024_e;

import java.util.Arrays;
import java.util.Scanner;

public class OD26日志采集系统_DP {
				/**
					* 2025/4/1
					* URL ：
					* 题目描述：
					* 一、题目描述
					* 日志采集是运维系统的的核心组件。日志是按行生成，每行记做一条，由采集系统分批上报。
					* <p>
					* 如果上报太频繁，会对服务端造成压力；
					* 如果上报太晚，会降低用户的体验；
					* 如果一次上报的条数太多，会导致超时失败。
					* 为此，项目组设计了如下的上报策略：
					* <p>
					* 每成功上报一条日志，奖励1分
					* 每条日志每延迟上报1秒，扣1分
					* 积累日志达到100条，必须立即上报
					* 给出日志序列，根据该规则，计算首次上报能获得的最多积分数。
					* <p>
					* 二、输入描述
					* 按时序产生的日志条数T1,T2…Tn，其中1 <= n <= 1000，0 <=Ti <= 100。
					* <p>
					* 三、输出描述
					* 首次上报最多能获得的积分数。3222
					**/
				public static void main(String[] args) {
								
								Scanner in = new Scanner(System.in);
								int[] logs = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
								int l = logs.length;
								// 提交日志得分
								int[] dp = new int[l];
								dp[0] = logs[0];
								
								// 因延迟得分
								int[] delay = new int[l];
								int max_score = dp[0] - delay[0];
								
								// todo i=1 从第二条日志开始
								for (int i = 1; i < l; i++) {
												// todo 日志超过100必须上报
												dp[i] = Math.min(100, dp[i - 1] + logs[i]);
												delay[i] = delay[i - 1] + dp[i - 1];
												
												max_score=Math.max(max_score,dp[i]-delay[i]);
												
												// 积压日志数>=100 必须上报
												if(dp[i]>=100){
																break;
												}
								}
								System.out.println(max_score);
				}
}
