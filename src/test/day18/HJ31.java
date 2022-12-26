package test.day18;

import java.util.Scanner;

public class HJ31 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String[] split = s.split("[^a-zA-Z]");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]+" ");
        }
        System.out.println(sb.toString());

    }

}
