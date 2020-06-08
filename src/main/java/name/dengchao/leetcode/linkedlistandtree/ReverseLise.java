package name.dengchao.leetcode.linkedlistandtree;

public class ReverseLise {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode last = null, cursor = head;
        while (cursor.next != null) {
            ListNode tmp = cursor.next;
            cursor.next = last;
            last = cursor;
            cursor = tmp;
        }
        cursor.next = last;
        return cursor;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        ListNode node1 = head, node2 = head.next;
        head.next = null;
        return reverse(node1, node2);
    }

    private ListNode reverse(ListNode node1, ListNode node2) {
        if (node2 == null) return node1;
        ListNode nextNode1 = node2, nextNode2 = node2.next;
        node2.next = node1;
        return reverse(nextNode1, nextNode2);
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(4);
        ListNode node14 = new ListNode(7);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        ReverseLise test = new ReverseLise();
        ListNode result = test.reverseList2(node11);
        while (result != null) {
            System.out.println(result);
            result = result.next;
        }
    }
}
