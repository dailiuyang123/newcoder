package ClassicExam.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.pow;

public class HJ76 {

    /**
     * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
     * <p>
     * 例如：
     * <p>
     * 1^3=1
     * <p>
     * 2^3=3+5
     * <p>
     * 3^3=7+9+11
     * <p>
     * 4^3=13+15+17+19
     * <p>
     * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
     * 数据范围：1\le m\le 100\1≤m≤100
     * <p>
     * https://www.nowcoder.com/practice/dbace3a5b3c4480e86ee3277f3fe1e85?tpId=37&tqId=21299&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=/exam/oj/ta?page=2&tpId=37&type=37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int avg = (int) Math.pow(n, 2);

        List<Integer> list = new ArrayList<>();

        int left = 0;
        int right = 0;
        int cnt = 0;
        if (n % 2 == 0) {
            right = avg + 1;
            left = avg - 1;
            cnt = 2;
            list.add(right);
            list.add(left);
        } else {
            list.add(avg);
            left = avg;
            right = avg;
            cnt = 1;
        }

        while (cnt < n) {
            left -= 2;
            right += 2;
            cnt += 2;
            list.add(left);
            list.add(right);
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i) + "";
            if (i != list.size() - 1) {
                s = s + "+";
            }
            System.out.print(s);
        }

    }


}
