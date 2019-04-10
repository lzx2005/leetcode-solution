/**
 * https://leetcode.com/explore/interview/card/microsoft/32/linked-list/170/
 * Created by hzlizx on 2019/4/10
 */
public class LinkedList170 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = l1;
        boolean carry = false;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                l1.val += l2.val;       //相加
                if (carry) l1.val++;    // 进位
                if (l1.val >= 10) {
                    l1.val %= 10;
                    carry = true;
                } else {
                    carry = false;
                }
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                l2.val = l2.val + (carry ? 1 : 0);
                if (l2.val >= 10) {
                    l2.val %= 10;
                    carry = true;
                } else {
                    carry = false;
                }
                end(head).next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                if (carry) l1.val++;
                if (l1.val >= 10) {
                    l1.val %= 10;
                    carry = true;
                } else {
                    carry = false;
                }
                l1 = l1.next;
            }
        }
        if (carry) {
            end(head).next = new ListNode(1);
        }
        return head;
    }


    private ListNode end(ListNode head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(8);
        ListNode listNode3 = new ListNode(0);
        listNode1.next = listNode2;

        ListNode listNode = new LinkedList170().addTwoNumbers(listNode1, listNode3);

        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
