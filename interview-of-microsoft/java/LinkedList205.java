import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/explore/interview/card/microsoft/32/linked-list/205/
 * Created by hzlizx on 2019/4/10
 */
public class LinkedList205 {

    private boolean carry = false;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int diff = size(l1) - size(l2);
        if (diff > 0) {
            l2 = addZero(l2, diff);
        } else {
            l1 = addZero(l1, -diff);
        }
        ListNode head = sum(l1, l2);
        if (carry) {
            ListNode listNode = new ListNode(1);
            listNode.next = head;
            return listNode;
        } else {
            return head;
        }
    }

    private ListNode sum(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode listNode = new ListNode(-1);
        listNode.next = sum(l1.next, l2.next);
        int i1 = l1.val;
        int i2 = l2.val;
        int sum = i1 + i2;
        sum += carry ? 1 : 0;
        carry = sum >= 10;
        sum = carry ? sum % 10 : sum;
        listNode.val = sum;
        return listNode;
    }

    private int size(ListNode listNode) {
        int size = 0;
        while (listNode != null) {
            size++;
            listNode = listNode.next;
        }
        return size;
    }

    private ListNode addZero(ListNode head, int count) {
        while (count > 0) {
            ListNode listNode = new ListNode(0);
            listNode.next = head;
            head = listNode;
            count--;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode l11 = new ListNode(7);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        ListNode l14 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;
        LinkedList205 linkedList205 = new LinkedList205();
        ListNode listNode = linkedList205.addTwoNumbers(l11, l21);
        listNode.print();
    }
}
