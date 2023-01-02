package ClassicExam.string;

public class NC100 {

    /**
     * 把字符串转换成整数
     */

    public int StrToInt(String s) {
        // write code here

        s = s.trim();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
                Long temp = Long.valueOf(sb.toString());
                if (temp > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (temp < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                continue;
            }

            if ((c == '+' || c == '-') && sb.length() == 0) {
                sb.append(c);
            } else {
                break;
            }

        }

        // todo: 注意测试用例："+"，"-"
        if (sb.toString().equals("+") || sb.toString().equals("-")) {
            return 0;
        }
        if (sb.length() > 0) {
            return Integer.valueOf(sb.toString());
        } else {
            return 0;
        }

    }


    public static void main(String[] args) {

        NC100 nc100 = new NC100();
        int i = nc100.StrToInt("13333744073709551617");
        System.out.println(i);

    }


}
