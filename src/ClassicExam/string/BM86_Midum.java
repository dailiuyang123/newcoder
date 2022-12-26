package ClassicExam.string;

import java.math.BigInteger;

public class BM86_Midum {

    /**
     * 大数加法：
     */
    public String solve(String s, String t) {
        // write code here

        if (s.length() == 0) {
            return t;
        }

        if (t.length() == 0) {
            return s;
        }

        BigInteger bigInteger=new BigInteger(t);
        BigInteger bigInteger1 = new BigInteger(s);


        BigInteger res = bigInteger.add(bigInteger1);

        return res.toString();

    }


}
