package ClassicExam.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NC384_123序列 {


    /**
     * https://www.nowcoder.com/practice/eae8142169a74ad7884bb5dca3264128?tpId=196&tqId=40515&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&page=1&tags=5058&difficulty=undefined&judgeStatus=undefined&tags=5058&title=
     */
    public boolean find132Subseq(ArrayList<Integer> nums) {
        // write code here

        boolean rs = false;

        for (int k = 2; k  < nums.size() ; k++) {
            int k_num = nums.get(k);
            int r = k - 1, l = 0;
            while (l < r) {
                if (nums.get(l) >= k_num) {
                    l++;
                }
                if (nums.get(r) <= k_num) {
                    r--;
                }
                if (nums.get(l) < k_num && nums.get(r) > k_num) {
                    return true;
                }
            }
        }

        return rs;
    }


    public static void main(String[] args) {

        NC384_123序列 nc384_123序列 = new NC384_123序列();
//        Integer[] nums = {23, 93, 18, 16, 35, 23};
        Integer[] nums = {23, 93, 18, 16, 35, 23};
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            integers.add(nums[i]);
        }

        boolean subseq = nc384_123序列.find132Subseq(integers);
        System.out.println(subseq);

    }

}
