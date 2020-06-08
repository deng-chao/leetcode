package name.dengchao.leetcode;

import name.dengchao.leetcode.model.ListNode;

public class LeetCode002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int num1 = 0;
        int b = 1;
        while (l1 != null) {
            num1 = num1 + l1.val * b;
            b = b * 10;
            l1 = l1.next;
        }
        int num2 = 0;
        b = 1;
        while (l2 != null) {
            num2 = num2 + l2.val * b;
            b = b * 10;
            l2 = l2.next;
        }
        int num3 = num1 + num2;
        if (num3 == 0) return new ListNode(0);
        ListNode dummy = new ListNode(0);
        ListNode curr = new ListNode(0);
        dummy.next = curr;
        while (num3 != 0) {
            curr.next = new ListNode(num3 % 10);
            curr = curr.next;
            num3 = num3 / 10;
        }
        return dummy.next.next;
    }

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    public static void test1() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        LeetCode002 code002 = new LeetCode002();
        ListNode node = code002.addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void test2() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);

        ListNode l2 = new ListNode(0);

        LeetCode002 code002 = new LeetCode002();
        ListNode node = code002.addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void test3() {
        ListNode l1 = new ListNode(9);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        LeetCode002 code002 = new LeetCode002();
        ListNode node = code002.addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
