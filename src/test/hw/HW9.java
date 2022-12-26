package test.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] s = ( n + "").toCharArray();
        List<Character> arr=new ArrayList<>();

        for (int i = s.length - 1; i >= 0; i--) {
            if(!arr.contains(s[i])){
                arr.add(s[i]);
            }
        }
        System.out.println(Integer.valueOf( arr.toString()));

    }
}
