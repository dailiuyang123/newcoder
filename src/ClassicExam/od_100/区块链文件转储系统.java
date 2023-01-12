package ClassicExam.od_100;

import java.util.Scanner;

public class 区块链文件转储系统 {

    /**
     *
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Integer M = Integer.valueOf(in.nextLine());
        String s = in.nextLine();
        String[] split = s.split("\\ ");
        int[] nums = new int[split.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(split[i]);
        }

        // 前缀和
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];
        }

        int rs = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = sums[j] - sums[i];
                if (temp <= M) {
                    if ((M - temp) < (M - rs)) {
                        rs = temp;
                    }
                }
            }
        }


        System.out.println(rs);
    }


}
