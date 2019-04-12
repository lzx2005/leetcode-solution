/**
 * https://leetcode.com/explore/interview/card/microsoft/32/linked-list/175/
 * Created by hzlizx on 2019/4/10
 */
public class LinkedList175 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        } else {
            ListNode head = null;
            if (l1.val <= l2.val) {
                head = l1;
                l1 = l1.next;
            } else {
                head = l2;
                l2 = l2.next;
            }
            ListNode point = head;
            while (l1 != null && l2 != null) {
                ListNode l1next = l1.next;
                ListNode l2next = l2.next;
                if (l1.val <= l2.val) {
                    point.next = l1;
                    l1 = l1next;
                } else {
                    point.next = l2;
                    l2 = l2next;
                }
                point = point.next;
            }
            if (l1 != null) {
                tail(head).next = l1;
            }
            if (l2 != null) {
                tail(head).next = l2;
            }
            return head;
        }
    }

    private ListNode tail(ListNode head) {
        if (head == null) {
            return null;
        }
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;
        LinkedList175 linkedList175 = new LinkedList175();
        ListNode listNode = linkedList175.mergeTwoLists(l11, l21);
        listNode.print();
    }
}
