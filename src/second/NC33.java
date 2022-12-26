package second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NC33 {

    /**
     * 合并两个排序的链表
     * <p>
     * 输入两个有序的链表
     */


public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
    public ListNode Merge(ListNode list1, ListNode list2) {

        List<Integer> list = new ArrayList<>();

        while (list1.next != null) {
            list.add(list1.val);
            list1 = list1.next;
        }
        while (list2.next != null) {
            list.add(list2.val);
            list2 = list2.next;
        }
        Collections.sort(list);
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            ListNode listNode = new ListNode(integer);
            temp = listNode;
            temp = temp.next;
        }
        return temp;
    }





}
