package ClassicExam.string;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NC63 {

    /**
     * 扑克牌顺子 https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4?tpId=117&tqId=37758&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=117&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public boolean IsContinuous(int[] numbers) {

        Arrays.sort(numbers);

        long count = Arrays.stream(numbers).filter(o -> 0 == o).count();

        if (count == 4) {
            return true;
        }
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                continue;
            }
            // 入栈
            if (stack.isEmpty() || (numbers[i] - stack.peek()) == 1) {
                stack.push(numbers[i]);
                continue;
            }

            while (numbers[i] - stack.peek() > 1) {
                if (count > 0) {
                    stack.push(stack.peek() + 1);
                    count--;
                } else {
                    return false;
                }
            }
            if ((numbers[i] - stack.peek()) == 1) {
                stack.push(numbers[i]);
            }
        }

        return stack.size() + count == 5;
    }


    public static void main(String[] args) {

        NC63 nc63 = new NC63();
        int[] nums = {11,10,0,0,12};
        boolean b = nc63.IsContinuous(nums);
        System.out.println(b);


    }


}
