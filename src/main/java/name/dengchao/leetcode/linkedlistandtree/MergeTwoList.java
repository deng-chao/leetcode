package name.dengchao.leetcode.linkedlistandtree;

public class MergeTwoList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = l1.val > l2.val ? new ListNode(l2.val) : new ListNode(l1.val);
        ListNode c1 = l1, c2 = l2, c0 = head;
        while (c1 != null && c2 != null) {
            if (c1.val < c2.val) {
                c0.next = c1;
                c1 = c1.next;
            } else {
                c0.next = c2;
                c2 = c2.next;
            }
            c0 = c0.next;
        }
        if (c1 == null) c0.next = c2;
        else if (c2 == null) c0.next = c1;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(4);
        node11.next = node12;
        node12.next = node13;
        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;
        MergeTwoList test = new MergeTwoList();
        test.mergeTwoLists(node11, node21);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val + "";
    }
}