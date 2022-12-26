package second;


import java.util.Scanner;

public class HJ31 {

    /**
     * 单词倒排
     * <p>
     * 对字符串种的所有单词进行倒排。
     */

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
