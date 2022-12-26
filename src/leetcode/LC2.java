package leetcode;

public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        return null;
    }

    public static void main(String[] args) {

        int[] l1 = {2, 4, 3};
        //创建首节点
        ListNode nodeSta = new ListNode();
        //声明一个变量用来在移动过程中指向当前节点
        ListNode nextNode;
        //指向首节点 ！！！！！！！！
        nextNode = nodeSta;
        for (int i : l1) {
            //生成新的节点
            ListNode node = new ListNode(i);
            //把新的节点连起来
            nextNode.next = node;
            //把当前节点往后移动 也就是说next后的对象下的next为null
            nextNode = nextNode.next;
        }
//        nextNode = nodeSta;
        System.out.println(nodeSta);
    }


}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

