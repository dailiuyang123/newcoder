package ClassicExam.ListNode;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BM1_反转链表 {


    /**
     * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，
     * 长度为n，反转该链表后，返回新链表的表头。
     */
    public ListNode ReverseList(ListNode head) {

        if(head==null){
            return head;
        }

        ListNode temp = head;
        Deque<Integer> stack = new ArrayDeque<>();

        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        ListNode heads=new ListNode(stack.pop());
        ListNode temps=heads;
        while (!stack.isEmpty()) {
            ListNode node = new ListNode(stack.pop());
            temps.next = node;
            temps = temps.next;
        }

        return heads;


    }


}
