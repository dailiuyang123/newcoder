package test.hw;

import java.util.Scanner;

public class Hw16 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        String[] arr = s.split(";");
        int[] z = {0,0};
        for (int i = 0; i < arr.length; i++) {
            z=step(arr[i],z);
        }
        System.out.println(z[0]+","+z[1]);
    }


    public static int[] step(String s, int[] z) {
        try {
            Integer v =  Integer.valueOf(s.substring(1, s.length())) ;
            if (s.startsWith("A")) {
                z[0]-=v;
            } else if (s.startsWith("D")) {
                z[0]+=v;
            } else if (s.startsWith("W")) {
                z[1]+=v;
            } else if (s.startsWith("S")) {
                z[1]-=v;
            }
        } catch (Exception e) {

        }
        return z;

    }
}
