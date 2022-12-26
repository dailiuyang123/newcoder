package test.hw;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Hw20 {


// 1.长度超过8位

//2.包括大小写字母.数字.其它符号,以上四种至少三种

//3.不能有长度大于2的不含公共元素的子串重复 （注：其他符号不含空格或换行）

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            // 判断字符串长度 是否符合要求
            if (s.length() <= 8) {
                System.out.println("N");
                continue;
            }

            // 判断是否包含三种以上类型
            if (!ismatch(s)) {
                System.out.println("N");
                continue;
            }

            // 判断是否包含长度最小为2的公共子串
            if (isSubString(s, 0, 3)) {
                System.out.println("N");
                continue;
            }
            System.out.println("OK");
        }


    }

    // 判断是否含有子串
    private static boolean isSubString(String s, int l, int r) {

        while (r < s.length()) {
            if (s.contains(s.substring(l, r))) {
                return true;
            } else {
                l++;
                r++;
            }
        }
        return false;


    }

    // 正则匹配是否符合多种类型
    private static boolean ismatch(String s) {
        int count = 0;

        Pattern p = Pattern.compile("[A-Z]");
        if (p.matcher(s).find()) {
            count++;
        }
        Pattern p1 = Pattern.compile("[a-z]");
        if (p1.matcher(s).find()) {
            count++;
        }
        Pattern p2 = Pattern.compile("[0-9]");
        if (p2.matcher(s).find()) {
            count++;
        }

        Pattern p3 = Pattern.compile("^[A-Z][a-z][0-9]");
        if (p2.matcher(s).find()) {
            count++;
        }

        if(count>=3){
            return true;
        }else {
            return false;
        }

    }


}
