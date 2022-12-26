package test.test;

import java.util.Scanner;

public class T1 {


    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner in =new Scanner(System.in);
        String s= in.nextLine();
        String s1=s.replace(" ","");
        String[] arr= s.split(" ");
        double v = (double) s1.length() / (double) arr.length;

        System.out.println(String.format("%.2f",v));


    }
}
