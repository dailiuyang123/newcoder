package leetcode.top100.链表;

public class LC21合并两个有序链表 {
				/**
					* 2025/9/2
					* URL ：
					* 题目描述：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
					**/
				
				public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
								
								if (list1 == null) {
												return list2;
								} else if (list2 == null) {
												return list1;
								} else if (list1.val < list2.val) {
												list1.next = mergeTwoLists(list1.next, list2);
												return list1;
								} else {
												list2.next = mergeTwoLists(list1, list2.next);
												return list2;
								}
								
				}
}
