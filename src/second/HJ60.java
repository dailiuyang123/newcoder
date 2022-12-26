package second;

import com.sun.scenario.effect.impl.prism.PrImage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ60 {

    /**
     * 查找组成一个偶数最接近的两个素数
     * <p>
     * 任意一个偶数（大于2）都可以由2个素数组成，
     * 组成偶数的2个素数有很多种情况，本题目要求
     * 输出组成制定偶数的两个素数最小的素数对
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int nextInt = in.nextInt();

        if (nextInt == 4) {
            System.out.println(2);
            System.out.println(2);
            return;
        }

        List<Integer> arr = new ArrayList<>();

        for (int i = 3; i <= nextInt / 2; i++) {
            int start = 2;
            boolean isSu = true;
            while (start < i) {
                if (i % start == 0) {
                    isSu = false;
                    break;
                }
                start++;
            }
            if (isSu) {
                arr.add(i);
            }
        }


        for (int i = arr.size() - 1; i >= 0; i--) {
            int i1 = nextInt - arr.get(i);
            int start = 2;
            boolean s = true;
            while (start < i1) {
                if (i1 % start == 0) {
                    s = false;
                    break;
                }
                start++;
            }

            if (s) {
                System.out.println(arr.get(i));
                System.out.println(i1);
                return;
            }

        }

        System.out.println(1);
        System.out.println(nextInt - 1);

    }


}
