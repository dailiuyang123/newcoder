package ClassicExam.array;


import java.util.ArrayList;
import java.util.List;

/**
 *  迭代了 5个版本才通过全部测试用例。
 *
 *  需要特别注意：特殊边界测试用例！！！！！
 *
 *
 */

public class LC86_M {

    /**
     * 分割链表 https://leetcode.cn/problems/partition-list/
     * @Version 5.0
     *
     * 需特别注意测试用例！！！
     * @Param [1,4,3,2,5,2] x=3
     * @Param [2,1] x=2
     * @Param [3,1] x=2
     * @Param [] x=0
     * @Param [1] x=2
     * @Param ..... 等等
     *
     *
     */
    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) {
            return head;
        }

        List<Integer> list = new ArrayList<>();

        ListNode temp = head;

        boolean after = false;
        List<Integer> adds = new ArrayList<>();

        while (temp != null) {
            if (temp.val < x) {
                adds.add(temp.val);
            } else {
                list.add(temp.val);
            }
            if (x == temp.val) {
                after = true;
            }
            temp = temp.next;
        }


        int sub = list.indexOf(x);
        int index = sub == -1 ? list.size() - 1 : list.indexOf(x) - 1;
        while (index >= 0) {
            if (list.get(index) >= x) {
                sub = index;
            }
            index--;
        }


        List<Integer> arrs = new ArrayList<>();
        if (adds.size() <= 0) {
            arrs = list;
        }
        if (list.size() <= 0) {
            arrs = adds;
        }

        if (adds.size() > 0 && list.size() > 0) {
            arrs.addAll(list.subList(0, sub));
            arrs.addAll(adds);
            arrs.addAll(list.subList(sub, list.size()));
        }

        ListNode result = new ListNode(arrs.get(0));
        temp = result;

        for (int i = 1; i < arrs.size(); i++) {
            ListNode node = new ListNode(arrs.get(i));
            temp.next = node;
            temp = temp.next;
        }

        return result;

    }


}
