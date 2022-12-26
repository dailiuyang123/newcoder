package second;

import java.util.Scanner;

public class HJ51_ListNode {

    /**
     * https://www.nowcoder.com/practice/54404a78aec1435a81150f15f899417d?tpId=37&tqId=21274&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * 输出单向链表中倒数第k个结点
     * <p>
     * 输入：  8
     * 1 2 3 4 5 6 7 8
     * 4
     * 输出：  5
     */


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {

            int i = in.nextInt(); // 链表长度
            // 构造 单向链表
            ListNode head = new ListNode(-1); //定义表头
            ListNode temp = head;
            for (int j = 0; j < i; j++) {
                int value = in.nextInt();
                temp.next = new ListNode(value);
                temp = temp.next;
            }

            // 2.遍历倒数第K节点的指针
            int k = in.nextInt();
            for (int j = 0; j < i - k + 1; j++) {
                head=head.next;
            }
            System.out.println(head.value);
        }

    }


}

class ListNode {

    int value;

    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode() {
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}