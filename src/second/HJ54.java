package second;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class HJ54 {

    /**
     *  表达式求值
     *
     *
     */

    public static void main(String[] args) {

        Scanner in =new Scanner(System.in);
        String s = in.nextLine();

        ScriptEngineManager manager=new ScriptEngineManager();
        ScriptEngine javascript = manager.getEngineByName("javascript");
        try {
            String s1 = javascript.eval(s).toString();
            System.out.println(s1);
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
    }

}
