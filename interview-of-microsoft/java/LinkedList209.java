/**
 * https://leetcode.com/explore/interview/card/microsoft/32/linked-list/209/
 * Created by hzlizx on 2019/4/10
 */
public class LinkedList209 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        int i = smallestNode(lists);
        if (i == -1) {
            return null;
        }
        ListNode head = lists[i];
        lists[i] = lists[i].next;
        ListNode point = head;
        while ((i = smallestNode(lists)) != -1) {
            ListNode next = lists[i].next;
            point.next = lists[i];
            lists[i] = next;
            point = point.next;
        }
        return head;
    }

    private int smallestNode(ListNode[] listNodes) {
        ListNode smallestNode = null;
        int index = -1;
        for (int i = 0; i < listNodes.length; i++) {
            if (listNodes[i] != null) {
                if (smallestNode == null) {
                    smallestNode = listNodes[i];
                    index = i;
                } else if (listNodes[i].val < smallestNode.val) {
                    smallestNode = listNodes[i];
                    index = i;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {

        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode l31 = new ListNode(2);
        ListNode l32 = new ListNode(6);
        l31.next = l32;


        ListNode[] listNodes = {l11, l21, l31};
        LinkedList209 linkedList209 = new LinkedList209();
        ListNode listNode = linkedList209.mergeKLists(listNodes);
        listNode.print();
    }
}
