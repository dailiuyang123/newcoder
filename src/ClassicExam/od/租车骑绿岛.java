package ClassicExam.od;

import java.util.Arrays;
import java.util.Scanner;

public class 租车骑绿岛 {

    /**
     * 部门组织绿岛骑行团建活动，租用公共双人自行车，每辆车最多坐两人，
     * 做最大载重M
     * <p>
     * 给出部门每个人的体重，请问最多需要租用多少辆双人自行车
     * <p>
     * 输入描述：
     * 第一行两个数字，m,n 代表每个人的体重，体重都小于自行车的限重m
     * 第二行，n 个数字，代表每个人的体重
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }

        Arrays.sort(num);

        int l = 0;
        int r = num.length - 1;

        int counts = 0;
        while (l <= r) {
            if (l == r) {
                counts++;
                break;
            }
            int sum = num[l] + num[r];
            if (sum > m) {
                counts++;
                r--;
            } else if (sum == m) {
                l++;
                r--;
                counts++;
            } else {
                l++;
                r--;
                counts++;
            }

        }

        System.out.println(counts);

    }


}
