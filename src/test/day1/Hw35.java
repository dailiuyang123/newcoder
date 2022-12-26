package test.day1;

import java.util.*;
import java.util.stream.Stream;

public class Hw35 {


//    https://www.nowcoder.com/practice/649b210ef44446e3b1cd1be6fa4cab5e?tpId=37&tqId=21258&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        List<String> list = new ArrayList<>();
        int max = max(n);
        for (int i = 0; i < n; i++) {
            List<Integer> arr=new ArrayList<>();
            int max_line = max - i;
            for (int m = n; m > i; m--) {
                arr.add(max_line);
                max_line -= m;
            }
            Collections.sort(arr);
            for (int k=0;k<arr.size();k++){
                System.out.print(arr.get(k)+" ");
            }
            System.out.println("");
        }

    }



    private static int max(int n) {
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max += i;
        }
        return max;
    }
}
