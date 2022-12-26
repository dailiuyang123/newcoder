package second;


/**
 * 删除链表的倒数第N个节点
 */
public class LC19_ListNode {


    /**
     *
     * ListNode temp = head;
     *
     * 注意：！！！
     *  temp = temp.nextNode; 只是获取，没有修改引用对象 【head 】
     *  temp.nextNode=temp.nextNode.nextNode; 修改了引用对象【head.next】属性的值。
     *  注意赋值的区别！！！！
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;  // <-----  修改了【temp】 引用对象的地址，【head】 未被修改 ：只是获取head的属性值,
        }
        // 获取要删除的正向节点
        int k = size - n - 1;
        if(k==0){
            return head.next;
        }
        int i = 0;
        ListNode t = head;
        while (i <= k) {
            if (i == k) {
                t.next = t.next == null ? null : t.next.next; // <--- 【t.nextNode】属性被修改，而 t 引用的是【head】的值
            } else {
                t = t.next;
            }
            i++;
        }
        return head;
    }


    public static void main(String[] args) {

        LC19_ListNode lc19ListNode = new LC19_ListNode();

        int[] arr = {1, 2, 3, 4, 5};

        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }

        ListNode listNode = lc19ListNode.removeNthFromEnd(head, 2);
        while (listNode != null) {
            System.out.println(listNode.value);
            listNode = listNode.next;
        }

    }


}
