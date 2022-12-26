package ClassicExam.string;

import java.util.Scanner;

public class HJ52_Midum_dp_undo {

    /**
     * 计算字符串的编辑距离：  https://www.nowcoder.com/practice/3959837097c7413a961a135d7104c314?tpId=37&tqId=21275&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=/exam/oj/ta?tpId=37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * Levenshtein 距离，又称编辑距离，指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。编辑距离的算法是首先由俄国科学家 Levenshtein 提出的，故又叫 Levenshtein Distance 。
     * <p>
     * 例如：
     * <p>
     * 字符串A: abcdefg
     * <p>
     * 字符串B: abcdef
     * <p>
     * 通过增加或是删掉字符 ”g” 的方式达到目的。这两种方案都需要一次操作。把这个操作所需要的次数定义为两个字符串的距离。
     * <p>
     * 要求：
     * <p>
     * 给定任意两个字符串，写出一个算法计算它们的编辑距离。
     * <p>
     * <p>
     * 数据范围：给定的字符串长度满足 1 \le len(str) \le 1000 \1≤len(str)≤1000
     */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String a = sc.nextLine();
            String b = sc.nextLine();
            int[][] dp = new int[a.length()+1][b.length()+1];  //定义动规数组

            for(int i=1; i<=a.length(); i++){  // 初始化
                dp[i][0] = i;
            }
            for(int i=1; i<=b.length(); i++){  // 初始化
                dp[0][i] = i;
            }
            for(int i=1; i<=a.length(); i++){
                for(int j=1; j<=b.length(); j++){
                    if(a.charAt(i-1)==b.charAt(j-1)){  //第一种情况
                        dp[i][j] = dp[i-1][j-1];
                    }else{  //第二种情况
                        dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i-1][j-1]+1, dp[i][j-1]+1));  //状态转移方程
                    }
                }
            }
            System.out.println(dp[a.length()][b.length()]);
        }
    }

}
