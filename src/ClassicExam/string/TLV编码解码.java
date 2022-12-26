package ClassicExam.string;

import java.util.Scanner;

public class TLV编码解码 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String tag = in.nextLine();

        String line = in.nextLine();

        String[] split = line.split("\\ ");

        int index = 0;


        StringBuilder sb = new StringBuilder();
        while (index < split.length) {

            if (!split[index].equals(tag)) {
                index++;
                index += Integer.valueOf(split[index],16) + 1;
            } else {
                index++;
                int begin = index + 2;
                for (int i = 0; i < Integer.parseInt(split[index],16); i++) {
                    sb.append(split[begin]).append(" ");
                    begin++;
                }
                break;
            }
            index++;
        }

        System.out.println(sb.toString().trim());


    }


}
