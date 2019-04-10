/**
 * https://leetcode.com/explore/interview/card/microsoft/32/linked-list/169/
 * Created by hzlizx on 2019/4/10
 */
public class LinkedList169 {

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
