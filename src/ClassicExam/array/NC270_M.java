package ClassicExam.array;

import java.util.Arrays;
import java.util.Comparator;

public class NC270_M {

    /**
     * 把数组排成最小的数
     * <p>
     * https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=196&tqId=39721&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public String PrintMinNumber(int[] numbers) {

        if (numbers.length <= 0) {
            return "";
        }

        if (numbers.length == 1) {
            return numbers[0] + "";
        }

        String[] nums = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i] + "";
        }

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }

        return sb.toString();
    }


}
