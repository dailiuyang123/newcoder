package ClassicExam.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NC313 {

    /**
     * 两个数组的交集
     * https://www.nowcoder.com/practice/56ea71d1f4e94de2aaec10e985874cce?tpId=196&tqId=40269&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&page=1&difficulty=2&tags=590&difficulty=2&judgeStatus=undefined&tags=590&title=
     */

    public ArrayList<Integer> intersection(ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
        // write code here
        Set<Integer> rs = new HashSet<>();
        if (nums1.size() > nums2.size()) {

            for (Integer integer : nums2) {
                if (nums1.contains(integer)) {
                    rs.add(integer);
                }
            }
        } else {
            for (Integer integer : nums1) {
                if (nums2.contains(integer)) {
                    rs.add(integer);
                }
            }
        }

        return new ArrayList<>(rs);


    }


}
