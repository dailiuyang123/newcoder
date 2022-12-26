package ClassicExam.string;

import java.util.Scanner;

public class NC114 {

    /**
     * 旋转字符串
     * https://www.nowcoder.com/practice/80b6bb8797644c83bc50ac761b72981c?tpId=117&tqId=37838&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=117&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */

    public boolean solve (String A, String B) {
        // write code here
        return (A+A).contains(B) && (A.length()==B.length());
    }

}
