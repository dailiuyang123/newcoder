package ClassicExam.array;

public class NC289 {


    /**
     * 删除链表的节点
     * https://www.nowcoder.com/practice/f9f78ca89ad643c99701a7142bd59f5d?tpId=196&tqId=39740&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */


    public ListNode deleteNode(ListNode head, int val) {
        // write code here
        ListNode temp = head;

        if (head.val == val) {
            return temp.next;
        }

        while (temp != null) {
            if (temp.next != null) {
                if (temp.next.val == val) {
                    temp.next = temp.next.next;
                    break;
                }
            }
            temp = temp.next;
        }

        return head;
    }


}
