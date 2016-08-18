package com.bo.bookcode;

import java.util.Currency;
import java.util.List;
import java.util.concurrent.BlockingDeque;

import com.bo.designpattern.Test;

public class ListQuestion {

	// 链表加法 从左到右加 进位时进到右边一位

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode pa = l1, pb = l2, cur = dummy;
		int carry = 0;
		while (pa != null || pb != null) {
			int x = (pa != null) ? pa.val : 0;
			int y = (pb != null) ? pb.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
			if (pa.next != null) {
				pa = pa.next;
			}
			if (pb.next != null) {
				pb = pb.next;
			}
		}
		if (carry != 0) {
			cur.next = new ListNode(carry);
		}

		return dummy.next;
	}

	// 链表一遍就地反转

	public static ListNode reverse(ListNode head, int m, int n) {
		if (m < 1) {
			return new ListNode(-1);
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode pre = dummy;
		for (int i = 0; i < m - 1; i++) {
			pre = pre.next;
		}

		ListNode cur = pre.next;
		ListNode curnext = cur.next;
		ListNode prenext = pre.next;
		for (int i = m; i < n; i++) {
			pre.next = curnext;
			cur.next = curnext.next;
			curnext.next = prenext;
			prenext = pre.next;
			curnext = cur.next;
		}

		return dummy.next;
	}

	public static void testRecerse() {
		ListNode head = construct(new int[] { 1, 2, 3, 4, 5, 6 });
		ListNode dummy = reverse(head, 1, 6);
		printList(dummy);
	}

	// 划分链表 使得小于某数的都在前面大于某数的都在后面

	public static ListNode partitioin(ListNode head, int x) {
		ListNode left_dummy = new ListNode(-1);
		ListNode right_dummy = new ListNode(-1);

		ListNode left = left_dummy, right = right_dummy;
		for (ListNode cur = head; cur != null; cur = cur.next) {
			if (cur.val < x) {
				left.next = cur;
				left = cur;
			} else {
				right.next = cur;
				right = cur;
			}
		}
		left.next = right_dummy.next;
		right.next = null;
		return left_dummy.next;
	}

	public static void testPartition() {
		ListNode head = construct(new int[] { 1, 4, 3, 2, 5, 2 });
		ListNode dummy = partitioin(head, 3);
		printList(dummy);
	}

	public static void main(String[] args) {
		// testRecerse();
		// testPartition();
		restRemove();
	}

	// 链表中删除重复 链表已经有序

	public static ListNode removeDuplicate(ListNode head) {
		ListNode pre = head;
		ListNode cur = pre.next;
		while (cur != null) {
			if (cur.val == pre.val) {
				pre.next = cur.next;
			}
			pre = pre.next;
			if (pre != null) {
				cur = pre.next;
			}else
				break;
			
		}
		return head;
	}
	
	public static ListNode removeAllDup(ListNode head){
		return null;
	}

	public static void restRemove() {
		ListNode head = construct(new int[] { 1, 1, 2, 3, 3 });
		printList(removeDuplicate(head));
	}

	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode construct(int[] arr) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		for (int i : arr) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}
		return dummy.next;
	}
}

class ListNode {
	ListNode next;
	int val;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}
