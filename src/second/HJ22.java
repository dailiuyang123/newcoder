package second;

import java.util.Scanner;

public class HJ22 {

    // 汽水瓶

    /**
     * 某商店规定：三个汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        boolean isEnd = false;

        int n = 0;
        while (!isEnd) {
            int nextInt = in.nextInt();
            isEnd = nextInt == 0 ? true : false;
            if (isEnd) {
                break;
            }
            while (nextInt >= 2) {
                if (nextInt == 2) {
                    n += 1;
                    break;
                }
                int curr = nextInt - (nextInt % 3);
                n += curr / 3;
                nextInt = curr / 3 + nextInt % 3;
            }

            System.out.println(n);
            n = 0;
        }

    }


}
