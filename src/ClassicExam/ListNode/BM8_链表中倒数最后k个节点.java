package ClassicExam.ListNode;

import java.util.ArrayList;
import java.util.List;

public class BM8_链表中倒数最后k个节点 {

    /**
     * 输入一个长度为 n 的链表，设链表中的元素的值为 ai ，返回该链表中倒数第k个节点。
     * 如果该链表长度小于k，请返回一个长度为 0 的链表。
     * <p>
     * <p>
     * 数据范围：0 \leq n \leq 10^50≤n≤10
     * 5
     * ，0 \leq a_i \leq 10^90≤a
     * i
     * ​
     * ≤10
     * 9
     * ，0 \leq k \leq 10^90≤k≤10
     *
     *
     */

    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here

        ListNode head = null;
        List<Integer> list = new ArrayList<>();
        while (pHead != null) {
            list.add(pHead.val);
            pHead = pHead.next;
        }
        // todo 注意边界值 k=0 测试用例
        if (list.size() < k || k==0) {
            return head;
        }

        int begin = list.size() - k;

        head = new ListNode(list.get(begin));
        ListNode temp = head;
        for (int i = begin + 1; i < list.size(); i++) {
            ListNode node = new ListNode(list.get(i));
            temp.next = node;
            temp = temp.next;
        }

        return head;
    }


}
