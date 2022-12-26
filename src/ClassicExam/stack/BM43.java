package ClassicExam.stack;

import java.util.Stack;

public class BM43 {

    /**
     * 包含min 函数的栈
     * <p>
     * https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=295&tqId=23268&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=/exam/oj
     */

    Stack<Integer> stackTotal = new Stack<>();
    Stack<Integer> stackLittle = new Stack<>();

    public void push(int node) {
        if (stackLittle.isEmpty()) {
            stackLittle.push(node);
        } else {
            if (node <= stackLittle.peek()) {
                stackLittle.push(node);
            } else {
                stackLittle.push(stackLittle.peek());
            }
        }
    }

    public void pop() {
        stackTotal.pop();
        stackLittle.pop();
    }

    public int top() {
        return stackTotal.peek();
    }

    public int min() {
        return stackLittle.peek();
    }


}
