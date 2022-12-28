package ClassicExam.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NC20_IP转换 {


    ArrayList<String> res = new ArrayList<>();

    /**
     * 现在有一个只包含数字的字符串，将该字符串转化成IP地址的形式，返回所有可能的情况。
     * 例如：
     * 给出的字符串为"25525522135",
     * 返回["255.255.22.135", "255.255.221.35"]. (顺序没有关系)
     * https://www.nowcoder.com/practice/ce73540d47374dbe85b3125f57727e1e?tpId=196&tqId=37059&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?page=1&tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        // write code here
        LinkedList<String> path = new LinkedList<>();
        dfs(s, 0, path);
        return res;
    }


    public void dfs(String s, int begin, LinkedList<String> path) {

        if (path.size() > 4) {
            return;
        }

        if (begin == s.length() && path.size() == 4) {
            res.add(toResult(path));
            return;
        }

        for (int i = begin; i < s.length(); i++) {
            String substring = s.substring(begin, i + 1);
            if (!isvalied(substring)) {
                continue;
            }
            path.offerLast(substring);
            dfs(s, i + 1, path);
            path.removeLast();
        }
    }

    boolean isvalied(String str) {

        if (str.length() == 1) {
            return true;
        }
        if (str.length() > 3) {
            return false;
        }

        if (Integer.valueOf(str) > 255) {
            return false;
        }

        if (str.charAt(0) == '0') {
            return false;
        }

        return true;
    }

    String toResult(LinkedList<String> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i != path.size() - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        NC20_IP转换 nc20_ip转换 = new NC20_IP转换();
        ArrayList<String> strings = nc20_ip转换.restoreIpAddresses("25525522135");
        System.out.println(strings.toString());

    }

}
