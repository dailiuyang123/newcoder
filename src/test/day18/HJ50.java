package test.day18;

import javax.script.ScriptEngineManager;
import java.util.Scanner;

public class HJ50 {

// 四则运算


    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        System.out.println(new ScriptEngineManager().getEngineByName("javascript").eval(s));
    }


}
