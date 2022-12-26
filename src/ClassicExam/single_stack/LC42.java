package ClassicExam.single_stack;


import java.util.Stack;

/**
 * 接雨水
 * <p>
 * 给定n个非负整数表示每个宽度为1的柱子高度图，计算按此排列的柱子，下雨后能接多少水
 * <p>
 * 单调栈
 */
public class LC42 {


    /**
     * 单调栈 经典解法
     */
    public int trap2(int[] height) {

        int sum = 0;
        int length = height.length;
        if (length < 3) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {

            // 栈不为空，且高度，大于栈顶高度
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {

                // 栈顶元素出栈
                int index = stack.pop();
                // 说明当前值和上个值是挨着的，前面也没有高柱子，不可能接到雨水
                if (stack.isEmpty()) {
                    break;
                }

                //栈顶值索引就是前面墙的距离
                Integer left = stack.peek();

                int min = Math.min(height[index], height[left]);

                sum += (min - height[index]) * (i - left - 1);
            }
            stack.push(i);
        }

        return sum;
    }


    public int trap(int[] height) {
        int size = height.length;
        if (size <= 2) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int sum = 0;
        for (int i = 1; i < size; i++) {
            Integer top = stack.peek();
            if (height[i] < height[top]) {
                stack.push(i);
            } else if (height[i] == height[top]) {
                stack.pop();
                stack.push(i);
            } else {
                // pop all lower value
                int heightAtIdx = height[i];
                while (!stack.isEmpty() && (heightAtIdx > height[top])) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int h = Math.min(height[left], height[i]) - height[mid];
                        int w = i - left - 1;
                        int hold = h * w;
                        if (hold > 0) {
                            sum += hold;
                        }
                        top = stack.peek();
                    }
                }
                stack.push(i);
            }
        }

        return sum;


    }


    public static void main(String[] args) {

        LC42 lc42 = new LC42();
        int[] heght = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int sum = lc42.trap(heght);
        System.out.println(sum);
    }


}
