package ClassicExam.od_100;

import java.util.Scanner;

public class 查找重复代码_动态规划 {


    /**
     * 查找重复代码
     * <p>
     * 题目描述
     * 小明负责维护项目下的代码，需要查找出重复代码，用以支撑后续的代码优化，请你帮助小明找出重复的代码。
     * 重复代码查找方法：以字符串形式给定两行代码（字符串长度 1 < length <= 100，由英文字母、数字和空格组成），找出两行代码中的最长公共子串。
     * 注：如果不存在公共子串，返回空字符串
     * <p>
     * 输入描述
     * 输入的参数text1, text2分别表示两行代码
     * <p>
     * 输出描述
     * 输出任一最长公共子串
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s1 = in.nextLine();
        String s2 = in.nextLine();

        int length = Math.min(s1.length(), s2.length());

        for (int i = length; i > 1; i--) {

            for (int j = 0; j + i <= length; j++) {

                String substring = s1.substring(j, j + i);
                if (s2.indexOf(substring) != -1) {
                    System.out.println(substring);
                    return;
                }

                String substring2 = s2.substring(j, j + i);
                if(s1.indexOf(substring2)!=-1){
                    System.out.println(substring2);
                    return;
                }
            }
        }

    }


}
