package ClassicExam.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BM2_链表内指定区间反转 {

    /**
     * 将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)。
     * 例如：
     * 给出的链表为 1\to 2 \to 3 \to 4 \to 5 \to NULL1→2→3→4→5→NULL, m=2,n=4m=2,n=4,
     * 返回 1\to 4\to 3\to 2\to 5\to NULL1→4→3→2→5→NULL.
     * <p>
     * 数据范围： 链表长度 0 < size \le 10000<size≤1000，0 < m \le n \le size0<m≤n≤size，链表中每个节点的值满足 |val| \le 1000∣val∣≤1000
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        if (n - m == 0) {
            return head;
        }

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] ints = list.stream().mapToInt(Integer::valueOf).toArray();
        // 使用数字两两交换
        int left = m - 1;
        int right = n - 1;
        int sum = left + right;
        int mid = left + (right - left) / 2;

        for (int i = left; i <= mid; i++) {
            Integer integer = ints[i];
            ints[i] = ints[sum - i];
            ints[sum - i] = integer;
        }

        ListNode heads = new ListNode(ints[0]);
        ListNode temp = heads;
        for (int i = 1; i < ints.length; i++) {
            ListNode node = new ListNode(ints[i]);
            temp.next = node;
            temp = temp.next;
        }
        return heads;
    }


}
