package od_2024_c.深度遍历;

import java.util.*;

public class 解密犯罪时间 {
    /**
     * 2024/3/3
     * URL ：https://blog.csdn.net/qfc_128220/article/details/127634016
     * 题目描述： 题目描述
     * 警察在侦破一个案件时，得到了线人给出的可能犯罪时间，形如 “HH:MM” 表示的时刻。
     * <p>
     * 根据警察和线人的约定，为了隐蔽，该时间是修改过的，
     * <p>
     * 解密规则为：利用当前出现过的数字，构造下一个距离当前时间最近的时刻，则该时间为可能的犯罪时间。
     * <p>
     * 每个出现数字都可以被无限次使用。
     * <p>
     * 输入描述
     * 形如HH:SS字符串，表示原始输入。
     * <p>
     * 输出描述
     * 形如HH:SS的字符串，表示推理处理的犯罪时间。
     **/
    static List<String> res = new ArrayList<>();

    static Set<Character> set = new HashSet<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        set.add(s.charAt(0));
        set.add(s.charAt(1));
        set.add(s.charAt(3));
        set.add(s.charAt(4));


    }

    public static void dfs(boolean[] used, LinkedList<Character> path) {

        if (path.size() == 4) {
            StringBuilder sb=new StringBuilder();
            for (Character character : path) {
                sb.append(character);
            }

        }

        for (Character character : set) {
            path.push(character);
            dfs(used, path);
            path.pop();
        }

    }


}
