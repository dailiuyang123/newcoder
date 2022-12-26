//package test.link;
//
//
//public class NC50 {
//
//    //链表中的节点每k个一组翻转
//
////    public ListNode reverseKGroup(ListNode head, int k) {
////        // write code here
////        Deque<ListNode> stack = new ArrayDeque<>();
////        ListNode listNode = new ListNode();
////        int i = 0;
////        while (head.next != null) {
////            i++;
////            if (i == k) {
////                listNode = head.next;
////                while (stack.isEmpty()) {
////                    listNode.next = stack.pop();
////                    listNode = listNode.next;
////                }
////                i = 0;
////            } else {
////                stack.push(head.next);
////            }
////            head = head.next;
////        }
////
////        while (stack.isEmpty()) {
////            listNode.next = stack.removeFirst();
////            listNode = listNode.next;
////        }
////
////        return listNode;
////
////    }
//
//    public ListNode reverseKGroup(ListNode head, int k) {
//        //先创建一个哑节点
//        ListNode dummy = new ListNode(0);
//        //让哑节点的指针指向链表的头
//        dummy.next = head;
//        //开始反转的前一个节点，比如反转的节点范围是[link1，link2],
//        //那么pre就是link1的前一个节点
//        ListNode pre = dummy;
//        ListNode end = dummy;
//        while (end.next != null) {
//            //每k个反转，end是每k个链表的最后一个
//            for (int i = 0; i < k && end != null; i++)
//                end = end.next;
//            //如果end是空，说明不够k个，就不需要反转了，直接退出循环。
//            if (end == null)
//                break;
//            //反转开始的节点
//            ListNode start = pre.next;
//            //next是下一次反转的头结点，先把他记录下来
//            ListNode next = end.next;
//            //因为end是这k个链表的最后一个结点，把它和原来链表断开，
//            //这k个节点我们可以把他们看做一个小的链表，然后反转这个
//            //小链表
//            end.next = null;
//            //因为pre是反转链表的前一个节点，我们把小链表[start,end]
//            //反转之后，让pre的指针指向这个反转的小链表
//            pre.next = reverse(start);
//            //注意经过上一步反转之后，start反转到链表的尾部了，就是已经
//            //反转之后的尾结点了，让他之前下一次反转的头结点即可（上面分析
//            //过，next就是下一次反转的头结点）
//            start.next = next;
//            //前面反转完了，要进入下一波了，pre和end都有重新赋值
//            pre = start;
//            end = start;
//        }
//        return dummy.next;
//    }
//
//    //链表的反转
//    private ListNode reverse(ListNode head) {
//        ListNode pre = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode next = curr.next;
//            curr.next = pre;
//            pre = curr;
//            curr = next;
//        }
//        return pre;
//    }
//
//}
