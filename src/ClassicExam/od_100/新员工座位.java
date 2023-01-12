package ClassicExam.od_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 新员工座位 {

    /**
     * 题目描述
     * 工位由序列F1,F2…Fn组成，Fi值为0、1或2。其中0代表空置，1代表有人，2代表障碍物。
     * <p>
     * 1、某一空位的友好度为左右连续老员工数之和，
     * 2、为方便新员工学习求助，优先安排友好度高的空位，
     * <p>
     * 给出工位序列，求所有空位中友好度的最大值。
     * <p>
     * 输入描述
     * 第一行为工位序列：F1，F2…Fn组成，
     * 1<=n<=10000，Fi值为0、1或2。其中0代表空置，1代表有人，2代表障碍物。
     * <p>
     * 输出描述
     * 所有空位中友好度的最大值。如果没有空位，返回0。
     * <p>
     * 用例
     * 输入	0 1 0
     * 输出	1
     * 说明	第1个位置和第3个位置，友好度均为1。
     * 输入	1 1 0 1 2 1 0
     * 输出	3
     * 说明	第3个位置友好度为3。因障碍物隔断，左边得2分，右边只能得1分。
     * 题目解析
     * 我的解题思路如下，首先将输入的数字数组转为字符串，比如“1101210”，然后将字符串按照“2”分割，得到一个字符串数组 [“1101”、“10”]，
     * <p>
     * 遍历每一个分割子串，比如“1101”，再按照“0”分割，又得到一个字符串数组 ["11", "1"]，将其转化为字符串长度数组为[2,1]，然后从左到右两两遍历求和，比如2+1=3就是一个空位的友好度，我们遍历求出最大的友好度，就是1101的片段的最大友好度。
     * <p>
     * 按此逻辑，再求出其他片段最大友好度。
     * <p>
     * 最后取所有片段中最大的友好度即为题解。
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = s.replaceAll("\\ ", "");

        int score = 0;
        String[] split = s.split("2");
        for (int i = 0; i < split.length; i++) {
            String s1 = split[i];
            String[] split1 = s1.split("0");

            List<Integer> nums = new ArrayList<>();
            for (int j = 0; j < split1.length; j++) {
                if (split1[j].length() > 0) {
                    nums.add(split1[j].length());
                }
            }

            int temp = nums.get(0);
            for (int j = 1; j < nums.size(); j++) {
                temp = Math.max(nums.get(j) + nums.get(j - 1), temp);
            }
            score = Math.max(temp, score);
        }

        System.out.println(score);
    }


}
