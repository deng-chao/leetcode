package name.dengchao.leetcode.linkedlistandtree;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || (l1.next == null && l1.val == 0)) return l2;
        if (l2 == null || (l2.next == null && l2.val == 0)) return l1;
        ListNode c1 = l1, c2 = l2, result = new ListNode(0), head = result;
        int sum, promotion = 0;
        while (true) {
            sum = (c1 == null ? 0 : c1.val) + (c2 == null ? 0 : c2.val);
            sum = sum + promotion;
            promotion = sum / 10;
            result.val = sum % 10;
            c1 = c1 == null ? null : c1.next;
            c2 = c2 == null ? null : c2.next;
            if (c1 == null && c2 == null) break;
            result.next = new ListNode(0);
            result = result.next;
        }
        if (promotion > 0) result.next = new ListNode(promotion);
        return head;
    }

    private ListNode reverse(ListNode head) {
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

    public static void main(String[] args) {
        ListNode node11 = new ListNode(5);
//        ListNode node12 = new ListNode(4);
//        ListNode node13 = new ListNode(3);
//        node11.next = node12;
//        node12.next = node13;
        ListNode node21 = new ListNode(5);
//        ListNode node22 = new ListNode(6);
//        ListNode node23 = new ListNode(4);
//        node21.next = node22;
//        node22.next = node23;
        AddTwoNumbers test = new AddTwoNumbers();
        System.out.println(test.addTwoNumbers(node11, node21));
    }
}
