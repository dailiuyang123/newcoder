package od_2024_c.暴力;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class 虚拟理财游戏 {
    /**
     * 2024/4/15
     * URL ：题目描述
     * 在一款虚拟游戏中生活，你必须进行投资以增强在虚拟游戏中的资产以免被淘汰出局。
     * <p>
     * 现有一家Bank，它提供有若干理财产品 m 个，风险及投资回报不同，你有 N（元）进行投资，能接收的总风险值为X。
     * <p>
     * 你要在可接受范围内选择最优的投资方式获得最大回报。
     * <p>
     * 备注：
     * <p>
     * 在虚拟游戏中，每项投资风险值相加为总风险值；
     * 在虚拟游戏中，最多只能投资2个理财产品；
     * 在虚拟游戏中，最小单位为整数，不能拆分为小数；
     * 投资额*回报率=投资回报
     * 输入描述
     * 第一行：
     * <p>
     * 产品数（取值范围[1,20]）
     * 总投资额（整数，取值范围[1, 10000]）
     * 可接受的总风险（整数，取值范围[1,200]）
     * 第二行：产品投资回报率序列，输入为整数，取值范围[1,60]
     * <p>
     * 第三行：产品风险值序列，输入为整数，取值范围[1, 100]
     * <p>
     * 第四行：最大投资额度序列，输入为整数，取值范围[1, 10000]
     * <p>
     * 输出描述
     * 每个产品的投资额序列
     * 题目描述：
     **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] one = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] hb = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] fx = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] limit = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int[] out = new int[one[0]];
        int max = 0;
        for (int i = 0; i < one[0]; i++) {
            int total = one[1];
            int risk = one[2];
            int temp = 0;

            risk -= fx[i];
            total -= limit[i];
            temp += hb[i] * limit[i];

            if (risk < 0) {
                continue;
            } else {
                if (temp > max) {
                    max = temp;
                    out = new int[one[0]];
                    out[i] = limit[i];
                }
                // 选择一个
                if (risk == 0 || total <= 0) {
                    continue;
                }
            }


            // 选择两个
            for (int j = i + 1; j < one[0]; j++) {
                int risk_t = risk - fx[j];
                int total_t = total - limit[j];
                int temp_t = temp + hb[j] * limit[j];

                if (total_t < 0 || risk_t < 0) {
                    continue;
                }
                if (temp_t > max) {
                    max = temp_t;
                    out = new int[one[0]];
                    out[i] = limit[i];
                    out[j] = limit[j];
                }
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < one[0]; i++) {
            sj.add(out[i] + "");
        }
        System.out.println(sj);
    }


}
