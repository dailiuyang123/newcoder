package test.hw;

import java.util.Scanner;

public class HW5 {

//    写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String val = s.substring(2, s.length());
        char a='2';
        int a1 = (int)a;
        System.out.println(a1);
        char[] chars = val.toCharArray();
        int result = 0;
        for (int i = val.length() -1; i >= 0; i--) {
            if(chars[i]=='A'){
                result+=10*Math.pow(16,val.length()-i-1);
            }else if(chars[i]=='B'){
                result+=11*Math.pow(16,val.length()-i-1);
            }else if(chars[i]=='C'){
                result+=12*Math.pow(16,val.length()-i-1);
            }else if(chars[i]=='D'){
                result+=13*Math.pow(16,val.length()-i-1);
            }else if(chars[i]=='E'){
                result+=14*Math.pow(16,val.length()-i-1);
            }else if(chars[i]=='F'){
                result+=15*Math.pow(16,val.length()-i-1);
            }else {
                result+= Integer.valueOf( Character.toString(chars[i]))*Math.pow(16,val.length()-i-1);
            }
        }
        System.out.println(result);

    }

}
