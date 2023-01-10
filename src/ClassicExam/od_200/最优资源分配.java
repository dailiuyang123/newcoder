package ClassicExam.od_200;

import java.util.Scanner;

public class 最优资源分配 {

    /**
     * 某块业务芯片最小容量单位为 1.25G, 总容量为 M*1.25G
     * <p>
     * 配置：
     * A：占用 1.25*1=1.25 G
     * B：占用 1.25*2=2.5 G
     * C：占用 1.25*8=10 G
     *
     * 输入：
     * 8
     * 2
     * ACABA
     *
     * 输出
     * 11111000
     * 11111111
     *
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();
        String string = sc.nextLine();

        int[] chip = new int[N];    //板卡上的芯片
        int conf; //配置所占容量
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == 'A') {
                conf = 1;
            } else if (c == 'B') {
                conf = 2;
            } else {
                conf = 8;
            }
            for (int j = 0; j < N; j++) {
                int used = chip[j];     //芯片占用的情况
                if (M - used >= conf) {  //芯片所剩容量大于等于配置所占容量
                    chip[j] += conf;
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            StringBuffer sb = new StringBuffer();
            int used = chip[i];     //芯片占用的情况
            for (int j = 0; j < M; j++) {
                if (j < used) {     //芯片占用的地方为1，未占用为0
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
            System.out.println(sb);
        }
    }


}
