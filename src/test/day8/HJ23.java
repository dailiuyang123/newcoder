package test.day8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ23 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.next();
        int[] index = new int[26];

        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 'a']++;
        }

        int min = s.length();
        List<Character> chars = new ArrayList();

        for (int i = 0; i < 26; i++) {
            if(index[i]==0){
               continue;
            }
            if (index[i] < min) {
                min = index[i];
                chars = new ArrayList<>();
                chars.add((char) (i + 'a'));
            } else if (index[i] == min) {
                chars.add((char) (i + 'a'));
            }
        }


        for (char c : chars) {
            s = s.replace(c+"", "");
        }


        System.out.println(s);


    }

}
