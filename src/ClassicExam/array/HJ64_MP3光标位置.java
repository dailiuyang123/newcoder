package ClassicExam.array;

import java.util.Scanner;

public class HJ64_MP3光标位置 {


    /**
     * mp3 光标位置
     * <p>
     * https://www.nowcoder.com/practice/eaf5b886bd6645dd9cfb5406f3753e15?tpId=37&tqId=21287&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=/exam/oj/ta?page=2&tpId=37&type=37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String cmd = sc.next();
            parseCmd(cmd, n);
        }
    }

    public static void parseCmd(String commands, int n) {
        // 页面的起始位置
        int start = 1;
        // 页面的末位置
        int end = Math.min(n, 4);
        // 光标的位置， 三个位置都是从1开始
        int index = 1;
        for(int i = 0; i < commands.length(); i++) {
            // 根据向上移动和向下移动的公式，光标位置的变化
            if(commands.charAt(i) == 'U') {
                index = (index-1-1+n) % n + 1;
            } else if(commands.charAt(i) == 'D') {
                index = index % n + 1;
            }
            // 判断滑动窗口的位置是否需要改变
            if(index < start) {
                // 光标在窗口之上
                start = index;
                end = start + 3;
            } else if(index > end){
                // 光标在窗口之下
                end = index;
                start = end - 3;
            }
        }
        // 输出窗口内容
        for(int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        // 打印当前光标
        System.out.println(index);
    }


}
