package test.day15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ21 {

    // 简单密码

//    九键手机键盘上的数字与字母的对应： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0，把密码中出现的小写字母都变成九键键盘对应的数字，如：a 变成 2，x 变成 9.
//    而密码中出现的大写字母则变成小写之后往后移一位，如：X ，先变成小写，再往后移一位，变成了 y ，例外：Z 往后移是 a 。
//    数字和其它的符号都不做变换。

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        String decr = "";
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (Character.isLetter(c)) {

                if (Character.isLowerCase(c)) {

                    if (c - 'a' <= 2) {
                        decr+='2';
                    }
                    if (c - 'd' <= 2 && c - 'd' >= 0) {
                        decr+='3';
                    }

                    if (c - 'g' <= 2 && c - 'g' >= 0) {
                        decr+='4';
                    }

                    if (c - 'j' <= 2 && c - 'j' >= 0) {
                        decr+='5';
                    }

                    if (c - 'm' <= 2 && c - 'm' >= 0) {
                        decr+='6';
                    }
                    if (c - 'p' <= 3 && c - 'p' >= 0) {
                        decr+='7';
                    }
                    if (c - 't' <= 2 && c - 't' >= 0) {
                        decr+='8';
                    }

                    if (c - 'w' <= 3 && c - 'w' >= 0) {
                        decr+='9';
                    }


                } else {
                    char c1 = Character.toLowerCase(c);
                    if(c1=='z'){
                        decr+='a';
                    }else {
                        decr+=(char)(c1+1);
                    }

                }

            } else {
                decr += c;
            }

        }

        System.out.println(decr);

    }

}
