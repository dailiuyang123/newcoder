package ClassicExam.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NC299_M {

    /**
     * 简化目录路径
     * https://www.nowcoder.com/practice/3177bcbfd947409ba833efb5a5b4a24c?tpId=196&tqId=40136&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * <p>
     * 给定一个目录路径的字符串path，path由英文字母，数字，"."，"/" 或 "_"组成，表示指向某一个文件或者目录的绝对路径，但是有的路径会有复杂的表达，比如"/../"其实还是代表的根目录路径"/"，请你将这个绝对路径转化为一个更加简洁的规范路径，转化规则如下：
     * 1.将1个点"."表示当前目录本身，即"/a/b/./"=>表示的还是"/a/b"
     * 2.将2个点".."表示将目前切换到上一级，即"/a/b/../"其实表示的是"/a"
     * 3.其他数目的点或者点加上其他字符视为一个普通目录路径，比如"/.../a.."表示的是根目下有一个名字为"..."的目录文件，"..."的文件下面还有一个名字为"a.."的文件
     * 4.任意多个连续的斜杠都被视为单个斜杠，即 "///"和"//"都被视为"/"
     * <p>
     * 你返回的简化规范路径应该如下:
     * 5.始终以斜杠 '/' 开头
     * 6.两个目录名之间必须只有一个斜杠 '/'
     * 7.最后一个目录名不能 以 '/' 结尾，根目录除外，根目录只有一个"/"
     * 8.路径仅包含从根目录到目标文件或目录的路径上的目录，即除了"."和".."的东西应该简化，其余的普通字符应该保留下来，视为目录路径
     */
    public String simplifyPath(String path) {
        // write code here
        Deque<String> stack = new ArrayDeque<>();
        String sub = "/";
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/' && sub == "/") {
                continue;
            }
            if (c == '/') { // 路径结束
                if (sub.equals("/..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!sub.equals("/.")) {
                    stack.push(sub);
                }
                sub = "/";
                continue;
            }
            sub += c;
        }

        if (!sub.equals("/")) {
            if (sub.equals("/..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!sub.equals("/.")) {
                stack.push(sub);
            }
        }


        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(stack);
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }

        return sb.toString().length() == 0 ? "/" : sb.toString();

    }


    public static void main(String[] args) {

        NC299_M nc299_m = new NC299_M();
        String s = nc299_m.simplifyPath("/..");
        System.out.println(s);

    }


}
