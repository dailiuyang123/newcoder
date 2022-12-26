package ClassicExam.string;

import com.sun.deploy.util.StringUtils;

import java.util.Scanner;

public class HJ90_M {

    /**
     * 合法ip
     * <p>
     * https://www.nowcoder.com/practice/995b8a548827494699dc38c3e2a54ee9?tpId=37&tqId=21313&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=/exam/oj/ta?difficulty=3&page=1&pageSize=50&search=&tpId=37&type=37&difficulty=3&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {

            String s = in.nextLine();
              // 匹配大于0的数字
//            boolean matches2 = s.matches("^[0-9]*$");
//            System.out.println(s+":"+ matches2);

            // todo 注意，以 "." 分割时，要加转义符\\转义
            String[] ip_arr = s.split("\\.");
            if (ip_arr.length != 4) {
                System.out.println("NO");
                continue;
            }

            boolean isvalid = true;
            for (int i = 0; i < ip_arr.length; i++) {
                // todo 注意： 特殊用例：+1.2.4.2  , 023.234.22.22 , .23.34.23
                if (ip_arr[i].length() == 0 || !ip_arr[i].matches("^[0-9]*$") || (ip_arr[i].length() > 1 && ip_arr[i].startsWith("0")) || Integer.valueOf(ip_arr[i]) < 0 || Integer.valueOf(ip_arr[i]) > 255) {
                    isvalid = false;
                    break;
                }
            }

            System.out.println(isvalid ? "YES" : "NO");
        }

    }


}
