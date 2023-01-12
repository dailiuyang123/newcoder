package ClassicExam.od_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 寻找相似单词 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Integer n = Integer.valueOf(in.nextLine());
        String[] strings = new String[n];


        for (int i = 0; i < n; i++) {
            strings[i] = in.nextLine();
        }
        Arrays.sort(strings);

        String Key = in.nextLine();
        char[] chars = Key.toCharArray();
        Arrays.sort(chars);
        String stand = String.valueOf(chars);

        List<String> rs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars1 = strings[i].toCharArray();
            Arrays.sort(chars1);
            if (String.valueOf(chars1).equals(stand)) {
                rs.add(strings[i]);
            }
        }

        if (rs.isEmpty()) {
            System.out.println("null");
        } else {
            for (int i = 0; i < rs.size(); i++) {
                System.out.print(rs.get(i));
                if (i != rs.size() - 1) {
                    System.out.print(" ");
                }
            }
        }
    }


}
